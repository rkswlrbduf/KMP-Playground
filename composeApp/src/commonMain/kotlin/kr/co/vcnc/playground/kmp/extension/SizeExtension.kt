package kr.co.vcnc.playground.kmp.extension

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity

val StatusBarHeightDp
    @Composable
    get() = with(LocalDensity.current) {
        WindowInsets.systemBars.getTop(this).toDp()
    }