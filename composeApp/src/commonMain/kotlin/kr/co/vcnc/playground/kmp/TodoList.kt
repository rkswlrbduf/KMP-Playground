package kr.co.vcnc.playground.kmp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kmpplayground.composeapp.generated.resources.Res
import kmpplayground.composeapp.generated.resources.compose_multiplatform
import kr.co.vcnc.compose.theme.TadaColor
import kr.co.vcnc.playground.kmp.model.Todo
import kr.co.vcnc.playground.kmp.theme.theme.TadaTypography
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TodoScreen(
    id: String,
    list: List<Todo>,
    onAddTodoClick: () -> Unit = {},
) {

    TodoList(
        modifier = Modifier.fillMaxSize(),
        todoList = list,
        onAddTodoClick = onAddTodoClick
    )

}

@Composable
fun TodoList(
    todoList: List<Todo>,
    modifier: Modifier = Modifier,
    onAddTodoClick: () -> Unit = {},
) {

    Surface(
        modifier = modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        Box {
            LazyColumn(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(todoList) { item ->
                    Todo(
                        modifier = Modifier
                            .fillMaxWidth(),
                        todo = item
                    )
                }
            }
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(10.dp)
                    .size(70.dp)
                    .border(width = 3.dp, color = TadaColor.TadaBlue, shape = CircleShape),
                onClick = onAddTodoClick,
                backgroundColor = TadaColor.TadaNavyLight,
                elevation = FloatingActionButtonDefaults.elevation(10.dp),
                content = {
                    Icon(
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .size(50.dp),
                        imageVector = vectorResource(Res.drawable.compose_multiplatform),
                        contentDescription = null,
                        tint = TadaColor.TadaBlue
                    )
                }
            )
        }
    }
}

@Composable
fun Todo(
    todo: Todo,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = TadaColor.Navy100, shape = RoundedCornerShape(4.dp))
            .padding(vertical = 15.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 4.dp),
                text = todo.name,
                style = TadaTypography.SP14Bold,
                color = TadaColor.Black
            )
            Text(
                text = todo.content,
                style = TadaTypography.SP12Regular,
                color = TadaColor.Gray700
            )
        }
        Text(
            modifier = Modifier
                .widthIn(max = 50.dp),
            text = todo.id,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = TadaTypography.SP14Regular,
            color = TadaColor.Gray700
        )
    }
}

@Preview
@Composable
fun TodoListPreview() {
    TodoList(todoList = List(10) { Todo.random })
}

