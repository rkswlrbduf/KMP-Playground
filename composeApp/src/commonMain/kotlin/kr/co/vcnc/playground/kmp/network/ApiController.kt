package kr.co.vcnc.playground.kmp.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.co.vcnc.playground.kmp.model.Todo
import org.koin.core.component.KoinComponent

class ApiController(
    private val client: HttpClient,
    private val ioDispatcher: CoroutineDispatcher,
) : KoinComponent {

    suspend fun getTasks(): List<Todo> = runCatching {
        withContext(ioDispatcher) {
            val response: List<Todo> = client.get("/tasks").body()
            response.sortedByDescending { it.createdAt }
        }
    }.getOrElse { e ->
        emptyList()
    }

    suspend fun updateTasks(todo: Todo) = runCatching {
        withContext(ioDispatcher) {
            client.post("/tasks") {
                contentType(ContentType.Application.Json)
                setBody(todo)
            }
        }
    }

}