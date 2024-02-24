package com.popularmovieapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.popularmovieapp.network.movielist.item.Movie
import com.popularmovieapp.viewmodel.MainViewModel

@Composable
fun MovieListScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val movieList by mainViewModel.movies.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn { //что-то тут не вяжется, как докопаться до элементов внутри
            this.items(movieList){
                MovieCard(movieListItem = it)
            }
        }
    }
}

@Composable
fun MovieCard(movieListItem: Movie) {
    val image = rememberImagePainter(data = movieListItem.poster)
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
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
                    contentDescription = "movie poster small",
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .height(75.dp)
                        .clip(RectangleShape)
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