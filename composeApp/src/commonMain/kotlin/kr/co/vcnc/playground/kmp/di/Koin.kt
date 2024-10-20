package kr.co.vcnc.playground.kmp.di

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kr.co.vcnc.playground.kmp.network.ApiController
import kr.co.vcnc.playground.kmp.repository.platformModule
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule(enableNetworkLogs = enableNetworkLogs), platformModule())
    }

fun commonModule(enableNetworkLogs: Boolean) = module {
    singleOf(::createJson)
    single { createHttpClient(get(), get(), enableNetworkLogs) }
    single { ApiController(get(), get()) }
}

fun createHttpClient(httpClientEngine: HttpClientEngine, json: Json, enableNetworkLogs: Boolean) =
    HttpClient(httpClientEngine) {

        defaultRequest {
            accept(ContentType.Application.Json)
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            url {
                protocol = URLProtocol.HTTPS
            }
//            this.host = "192.168.219.107"
            this.host = "kyuyeol.du.r.appspot.com"
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15_000L
            connectTimeoutMillis = 15_000L
            socketTimeoutMillis = 15_000L
        }

        install(ContentNegotiation) {
            json(json)
        }

        if (enableNetworkLogs) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }

fun createJson() = Json {
    encodeDefaults = true
    isLenient = true
    coerceInputValues = true
    ignoreUnknownKeys = true
    prettyPrint = true
}