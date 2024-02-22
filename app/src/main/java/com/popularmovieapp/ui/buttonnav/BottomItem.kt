package com.popularmovieapp.ui.buttonnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItem(val route: String, val icon: ImageVector, val label: String) {
    data object AppInfoScreen : BottomItem("app_info", Icons.Default.Info, "App Info")
    data object MovieListScreen : BottomItem("movie_list", Icons.AutoMirrored.Filled.List, "Movie List")
}