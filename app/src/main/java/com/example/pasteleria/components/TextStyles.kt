package com.example.pasteleria.components


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow

val ChocolateBrown = Color(0xFF4B2E2E)
val ShadowBrown = Color(0xFF3D2626)

val h1Style = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontSize = 28.sp,
    fontWeight = FontWeight.Bold,
    color = ChocolateBrown,
    shadow = Shadow(
        color = ShadowBrown,
        offset = Offset(2f, 2f),
        blurRadius = 3f
    ),
    letterSpacing = 2.sp,
    textAlign = TextAlign.Center
)

val pStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontSize = 16.sp,
    color = ChocolateBrown,
    lineHeight = 22.sp,
    textAlign = TextAlign.Justify
)
