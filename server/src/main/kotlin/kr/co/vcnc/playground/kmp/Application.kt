package kr.co.vcnc.playground.kmp

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kr.co.vcnc.playground.kmp.model.Todo


fun main() {
    embeddedServer(
        Netty,
        port = SERVER_PORT,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

val httpClient = HttpClient(CIO) {

    this.install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) {
        json(
            Json {
                encodeDefaults = true
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            }
        )
    }
    this.defaultRequest {
        url {
            protocol = URLProtocol.HTTPS
        }
        this.host = "qatchmind-default-rtdb.asia-southeast1.firebasedatabase.app"
    }
}

fun Application.module() {

    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
        allowHeader(HttpHeaders.Authorization)
        allowHost("qatchmind-default-rtdb.asia-southeast1.firebasedatabase.app")
        allowHost("client-host")
        allowHost("client-host:8081")
        allowHost("0.0.0.0:8080")
        allowHost("0.0.0.0:8081")
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Patch)
    }

    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }

    routing {
        get("/") {
            call.respondText("GOOD")
        }
        get("tasks") {
            val data: Map<String, Todo> =
                httpClient.get("/users.json").body()
            call.response.headers.apply {
                append(
                    HttpHeaders.ContentType,
                    "application/json"
                )
                append(
                    HttpHeaders.Accept,
                    "application/json"
                )
            }
            call.respond(data.values.toList())
        }
        post("tasks") {
            val todo = this.call.receive<Todo>()

            val response = httpClient.post("/users.json") {
                contentType(ContentType.Application.Json)
                setBody(todo)
            }
            call.response.headers.apply {
                append(HttpHeaders.ContentType, "application/json")
                append(HttpHeaders.Accept, "application/json")
            }
            call.respond(HttpStatusCode.Created)
        }
    }
}