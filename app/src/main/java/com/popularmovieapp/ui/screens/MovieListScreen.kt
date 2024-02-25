package com.popularmovieapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.popularmovieapp.movielist.domain.Movie
import com.popularmovieapp.ui.navigation.NavScreen
import com.popularmovieapp.viewmodel.MainViewModel

@Composable
fun MovieListScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val movieList by mainViewModel.movies.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn {
            this.items(movieList) {
                MovieCard(movieListItem = it, navHostController)
            }
        }
    }
}

@Composable
fun MovieCard(movieListItem: Movie, navHostController: NavHostController) {
    val image = rememberImagePainter(data = movieListItem.poster)

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .clickable {
                navHostController.navigate(route = "${NavScreen.MOVIE_DETAIL.route}/$movieListItem")
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Row(
                Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(RoundedCornerShape(5.dp))
                )
                Column(
                    Modifier
                        .padding(10.dp)
                        .weight(weight = 1F, fill = true)
                ) {
                    Text(text = movieListItem.name, fontSize = 20.sp, fontWeight = FontWeight(800))
                    Text(text = movieListItem.alternativeName, fontSize = 15.sp)
                }
                Text(
                    text = movieListItem.rating,
                    fontSize = 24.sp,
                    fontWeight = FontWeight(800),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}