package com.popularmovieapp.ui.buttonnav

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.popularmovieapp.ui.screens.AppInfoScreen
import com.popularmovieapp.ui.screens.MovieListScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "app_info"){
        composable("app_info"){
            AppInfoScreen()
        }
        composable("movie_list"){
            MovieListScreen()
        }
    }
}