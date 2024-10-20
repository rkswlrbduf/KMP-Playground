package kr.co.vcnc.playground.kmp

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Desktop
import java.awt.Dimension

internal val desktop = Desktop.getDesktop()

fun main() = application {

    val windowState = rememberWindowState(width = 1500.dp, height = 1000.dp)

    Window(
        title = "Tada",
        state = windowState,
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        App()
    }
}