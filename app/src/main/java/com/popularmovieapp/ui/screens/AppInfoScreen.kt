package com.popularmovieapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AppInfoScreen() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text="Welcome to Popular Movie App",
        textAlign = TextAlign.Center
    )
}