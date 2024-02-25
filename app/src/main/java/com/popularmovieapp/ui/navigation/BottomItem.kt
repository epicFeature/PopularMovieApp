package com.popularmovieapp.ui.navigation

sealed class BottomItem(val navScreen: NavScreen) {
    data object AppInfoScreen : BottomItem(NavScreen.APP_INFO)
    data object MovieListScreen : BottomItem(NavScreen.MOVIE_LIST)
}