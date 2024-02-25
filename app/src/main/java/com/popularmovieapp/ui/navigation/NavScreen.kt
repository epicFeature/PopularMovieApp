package com.popularmovieapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavScreen(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    APP_INFO("app_info", Icons.Default.Info, "App information"),
    MOVIE_LIST("movie_list", Icons.AutoMirrored.Filled.List, "List of movies"),
    MOVIE_DETAIL("movie_detail", Icons.Default.Search, "Movie Detail")

}