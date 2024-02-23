package com.popularmovieapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MovieListScreen() {
    Text(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .background(Color.White),
        text = "List of popular Movies",
        textAlign = TextAlign.Center
    )
}