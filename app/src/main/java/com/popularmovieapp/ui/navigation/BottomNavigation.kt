package com.popularmovieapp.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.popularmovieapp.ui.theme.Orange600

@Composable
fun BottomNavigation(
    navController: NavController
) {
    val listItems = listOf(
        BottomItem.AppInfoScreen,
        BottomItem.MovieListScreen
    )
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        listItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRout == item.navScreen.route,
                onClick = {
                    navController.navigate(item.navScreen.route)
                },
                icon = {
                    Icon(
                        imageVector = item.navScreen.icon,
                        contentDescription = "Icon"
                    )
                },
                label = {
                    Text(
                        text = item.navScreen.label,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Orange600,
                unselectedContentColor = Color.Gray
            )
        }
    }
}