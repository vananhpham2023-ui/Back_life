package com.linghui.core.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val LightColors =
    lightColorScheme(
        primary = Color(0xFF2F4858),
        onPrimary = Color(0xFFFFFFFF),
        secondary = Color(0xFF86A8B5),
        onSecondary = Color(0xFF1D2933),
        background = Color(0xFFF7F6F2),
        onBackground = Color(0xFF1D2933),
        surface = Color(0xFFFFFFFF),
        onSurface = Color(0xFF1D2933),
    )

val DarkColors =
    darkColorScheme(
        primary = Color(0xFF7FA7B3),
        onPrimary = Color(0xFF0E1A20),
        secondary = Color(0xFFB7C7CE),
        onSecondary = Color(0xFF0E1A20),
        background = Color(0xFF121415),
        onBackground = Color(0xFFE6E8EA),
        surface = Color(0xFF1A1D1F),
        onSurface = Color(0xFFE6E8EA),
    )
