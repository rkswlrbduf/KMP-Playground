package kr.co.vcnc.playground.kmp.repository

import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

actual fun platformModule() = module {
    single { OkHttp.create() }
    single<CoroutineDispatcher> { Dispatchers.IO }
}