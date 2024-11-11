package com.whitemonkeys.botcreator.uikit

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.getFontResourceBytes
import whitemonkeysbotcreator.composeapp.generated.resources.Res
import whitemonkeysbotcreator.composeapp.generated.resources.aeroport
import whitemonkeysbotcreator.composeapp.generated.resources.aeroport_bold

private val AeroportFamily = FontFamily(
//    Font(getFontResourceBytes(Res.font.aeroport), FontWeight.Normal),
//    Font(Res.font.aeroport_bold, FontWeight.Bold),
//    Font(Res.font.aeroport_light, FontWeight.Light),
//    Font(Res.font.aeroport_medium, FontWeight.Medium),
//    Font(Res.font.aeroport_italic, FontWeight.Normal, FontStyle.Italic),
)

object AeroportFamilyTypography {
    val largeTitle: TextStyle = TextStyle(
        fontFamily = AeroportFamily,
        fontSize = 40.sp,
        lineHeight = 48.sp
    )
}