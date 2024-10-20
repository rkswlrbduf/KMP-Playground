package kr.co.vcnc.playground.kmp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import kotlinx.coroutines.*
import kotlinx.datetime.Clock
import kotlinx.serialization.Serializable
import kr.co.vcnc.playground.kmp.di.initKoin
import kr.co.vcnc.playground.kmp.network.ApiController
import org.jetbrains.compose.ui.tooling.preview.Preview

internal val koin = initKoin(true) { }.koin
internal val apiController = koin.get<ApiController>()
internal val ioDispatcher = koin.get<CoroutineDispatcher>()

@Composable
@Preview
fun App() {
    MaterialTheme {

        val navController = rememberNavController()

        val scope = rememberCoroutineScope { ioDispatcher }

        NavHost(
            navController = navController,
            startDestination = Login
        ) {
            composable<Login> {
                var id: String by remember { mutableStateOf("") }

                LaunchedEffect(id) {
                    if (id.isNotBlank()) {
                        navController.navigate(
                            TodoList(
                                id = id,
                            )
                        ) {
                            popUpTo(Login) {
                                inclusive = true
                            }
                        }
                    }
                }

                Login(onLoginClick = { id = it })
            }
            navigation<Todo>(
                startDestination = TodoList::class
            ) {
                composable<TodoList> {
                    val todoListRoute = it.toRoute<TodoList>()

                    val list = remember { mutableStateListOf<kr.co.vcnc.playground.kmp.model.Todo>() }

                    DisposableEffect(Unit) {

                        val job = scope.launch {
                            while (isActive) {
                                val response = apiController.getTasks()
                                list.clear()
                                list.addAll(response)
                                delay(1_000)
                            }
                        }

                        onDispose {
                            job.cancel()
                        }
                    }

                    TodoScreen(
                        id = todoListRoute.id,
                        list = list,
                        onAddTodoClick = {
                            navController.navigate(Input(id = todoListRoute.id))
                        }
                    )
                }
                composable<Input> {

                    val inputRoute = it.toRoute<Input>()

                    InputScreen(
                        id = inputRoute.id,
                        onAddTodoClick = { title, content ->
                            navController.popBackStack()
                            scope.launch {
                                apiController.updateTasks(
                                    kr.co.vcnc.playground.kmp.model.Todo(
                                        id = inputRoute.id,
                                        name = title,
                                        content = content,
                                        createdAt = Clock.System.now().toEpochMilliseconds(),
                                        isDone = true
                                    )
                                )
                            }
                        },
                        onBackPressed = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}

@Serializable
object Login

@Serializable
object Todo

@Serializable
data class TodoList(
    val id: String,
)

@Serializable
data class Input(
    val id: String,
)

