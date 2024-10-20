package kr.co.vcnc.playground.kmp.theme.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import kmpplayground.composeapp.generated.resources.Res
import kmpplayground.composeapp.generated.resources.spoqa_han_sans_bold
import kmpplayground.composeapp.generated.resources.spoqa_han_sans_regular
import org.jetbrains.compose.resources.Font

object TadaTypography {

    private val fontFamily
        @Composable
        get() = FontFamily(
            Font(Res.font.spoqa_han_sans_regular, FontWeight.Normal),
            Font(Res.font.spoqa_han_sans_bold, FontWeight.Bold)
        )

    val SP10Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(10f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP10Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(10f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

    val SP12Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(12f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP12Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(12f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

    val SP14Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP14Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(14f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

    val SP16Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(16f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP16Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(16f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

    val SP18Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(18f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP18Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(18f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

    val SP20Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP20Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(20f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

    val SP22Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(22f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP22Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(22f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

    val SP24Regular: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(24f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
        )

    val SP24Bold: TextStyle
        @Composable
        get() = TextStyle.Default.copy(
            fontSize = TextUnit(24f, TextUnitType.Sp),
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
        )

}