package com.popularmovieapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.popularmovieapp.movielist.domain.Movie
import com.popularmovieapp.ui.navigation.types.MovieArgType
import com.popularmovieapp.ui.screens.AppInfoScreen
import com.popularmovieapp.ui.screens.MovieDetailScreen
import com.popularmovieapp.ui.screens.MovieListScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = NavScreen.APP_INFO.route) {
        composable(NavScreen.APP_INFO.route) {
            AppInfoScreen()
        }
        composable(NavScreen.MOVIE_LIST.route) {
            MovieListScreen(navHostController = navHostController)
        }
        composable(
            route = "${NavScreen.MOVIE_DETAIL.route}/{movie}",
            arguments = listOf(
                navArgument("movie") {
                    type = MovieArgType()
                }
            )
        ) { backStackEntry ->
            val movie = backStackEntry.arguments
                ?.getString("movie")
                ?.let { Movie.fromJson(it) }
            MovieDetailScreen(movie = movie!!)
        }
    }
}

