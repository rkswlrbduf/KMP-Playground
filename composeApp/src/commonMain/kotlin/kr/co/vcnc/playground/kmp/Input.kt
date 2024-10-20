package kr.co.vcnc.playground.kmp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import kmpplayground.composeapp.generated.resources.Res
import kmpplayground.composeapp.generated.resources.btn_back
import kr.co.vcnc.compose.theme.TadaColor
import kr.co.vcnc.playground.kmp.theme.theme.TadaAppbar
import kr.co.vcnc.playground.kmp.theme.theme.TadaTypography
import org.jetbrains.compose.resources.painterResource

@Composable
fun InputScreen(
    id: String,
    onAddTodoClick: (title: String, content: String) -> Unit,
    onBackPressed: () -> Unit,
) {

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TadaAppbar(
                    title = {
                        Text(
                            "메모 추가",
                            style = TadaTypography.SP18Regular
                        )
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier
                                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp),
                            onClick = {
                                keyboardController?.hide()
                                onBackPressed.invoke()
                            }
                        ) {
                            Icon(
                                painter = painterResource(Res.drawable.btn_back),
                                tint = TadaColor.Black,
                                contentDescription = ""
                            )
                        }
                    },
                )
            },
            bottomBar = {
                Button(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = TadaColor.TadaNavy,
                        contentColor = TadaColor.White,
                    ),
                    contentPadding = PaddingValues(15.dp),
                    onClick = { onAddTodoClick.invoke(title, content) },
                    content = {
                        Text(
                            text = "TODO 만들기",
                            style = TadaTypography.SP16Bold,
                        )
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 25.dp,
                                top = 20.dp,
                                end = 25.dp,
                                bottom = 20.dp
                            ),
                        text = "제목",
                        style = TadaTypography.SP16Bold,
                        color = TadaColor.Black,
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(
                                start = 25.dp,
                                end = 25.dp,
                                bottom = 40.dp
                            )
                            .fillMaxWidth(),
                        value = title,
                        onValueChange = { title = it },
                        maxLines = 1,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = TadaColor.TadaBlue,
                            unfocusedBorderColor = TadaColor.Navy100,
                        ),
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 25.dp,
                                end = 25.dp,
                                bottom = 20.dp
                            ),
                        text = "내용",
                        style = TadaTypography.SP16Bold,
                        color = TadaColor.Black,
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(horizontal = 25.dp)
                            .fillMaxWidth()
                            .heightIn(min = 100.dp, max = 300.dp),
                        value = content,
                        onValueChange = { content = it },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = TadaColor.TadaBlue,
                            unfocusedBorderColor = TadaColor.Navy100,
                        ),
                    )
                }
            }
        )
    }
}

