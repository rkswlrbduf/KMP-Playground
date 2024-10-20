package kr.co.vcnc.playground.kmp.theme.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.co.vcnc.compose.theme.TadaColor
import kr.co.vcnc.playground.kmp.extension.StatusBarHeightDp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TadaAppbar(
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = TadaColor.White,
    statusBarPaddingRequired: Boolean = false,
) {

    CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {

        TopAppBar(
            modifier = modifier,
            contentPadding = PaddingValues(
                start = 8.dp,
                end = 8.dp,
                top = if (statusBarPaddingRequired) StatusBarHeightDp else 0.dp),
            backgroundColor = backgroundColor,
            elevation = 0.dp
        ) {

            navigationIcon?.let {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    CompositionLocalProvider(
                        LocalMinimumInteractiveComponentEnforcement provides false,
                        content = navigationIcon
                    )
                }
            }

            title?.let {
                Row(
                    Modifier
                        .weight(1f)
                        .padding(horizontal = 20.dp, vertical = 0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProvideTextStyle(value = MaterialTheme.typography.h6) {
                        CompositionLocalProvider(
                            LocalContentAlpha provides ContentAlpha.high,
                            content = title
                        )
                    }
                }
            }

            Row(
                Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                content = actions
            )
        }
    }
}