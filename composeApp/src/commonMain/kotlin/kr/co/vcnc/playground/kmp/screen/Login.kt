package kr.co.vcnc.playground.kmp


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import kr.co.vcnc.compose.theme.TadaColor
import kr.co.vcnc.playground.kmp.theme.theme.TadaTypography
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun Login(
    onLoginClick: (String) -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    var id by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(IntrinsicSize.Max),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OutlinedTextField(
                    value = id,
                    onValueChange = { id = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = TadaColor.TadaBlue,
                        unfocusedBorderColor = TadaColor.Navy100,
                    ),
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    onClick = {
                        keyboardController?.hide()
                        onLoginClick.invoke(id)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = TadaColor.TadaNavy,
                        contentColor = TadaColor.White,
                    ),
                    content = {
                        Text(
                            text = "로그인 하기",
                            style = TadaTypography.SP16Bold,
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    Login(
        onLoginClick = {}
    )
}