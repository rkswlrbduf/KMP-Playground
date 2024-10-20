package kr.co.vcnc.playground.kmp.repository

import org.koin.core.module.Module
import org.koin.dsl.module
import io.ktor.client.engine.okhttp.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun platformModule(): Module = module {
    single { OkHttp.create() }
    single<CoroutineDispatcher> { Dispatchers.IO }
}