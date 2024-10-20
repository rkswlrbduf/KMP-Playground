package kr.co.vcnc.playground.kmp.repository

import io.ktor.client.engine.darwin.*
import org.koin.dsl.module
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual fun platformModule() = module {
    single { Darwin.create() }
    single<CoroutineDispatcher> { Dispatchers.Default }
}