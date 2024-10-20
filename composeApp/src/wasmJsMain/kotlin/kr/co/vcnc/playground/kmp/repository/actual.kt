package kr.co.vcnc.playground.kmp.repository

import io.ktor.client.engine.js.Js
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

actual fun platformModule() = module {
    single { Js.create() }
    single<CoroutineDispatcher> { Dispatchers.Default }
}