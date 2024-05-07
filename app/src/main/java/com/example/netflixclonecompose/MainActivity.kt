package com.example.netflixclonecompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ) {
                TopAppSection()
                ContentChooser()
                FeaturedMovieSection()
                addMovieList(movieType = "Best Shows")
                addMovieList(movieType = "Top 10 Picks")
                addMovieList(movieType = "Trending Today")
                addMovieList(movieType = "Hollywood")
                addMovieList(movieType = "Best Shows")
                addMovieList(movieType = "Top 10 Picks")
                addMovieList(movieType = "Trending Today")
                addMovieList(movieType = "Hollywood")


            }

        }
    }

    @Composable
    fun TopAppSection() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 6.dp, bottom = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.netflix_icon),
                contentDescription = "Icon",
                modifier = Modifier.size(60.dp)
            )
            Row(

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(40.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Search",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(40.dp)
                )
            }


        }

    }

    @Composable
    fun ContentChooser() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(vertical = 6.dp)
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "TV Shows", color = Color.LightGray, fontSize = 20.sp)
            Text(text = "Movies", color = Color.LightGray, fontSize = 20.sp)
            Row() {
                Text(text = "Categories", color = Color.LightGray, fontSize = 20.sp)
                Image(painter = painterResource(id = R.drawable.ic_drop), contentDescription = "DropDown")

            }

        }
    }
    @Composable
    fun FeaturedMovieSection(){
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
            )
        {
            Image(painter = painterResource(id = R.drawable.image1), contentDescription = "" , modifier = Modifier.padding(start = 90.dp, end = 90.dp, top = 10.dp, bottom = 10.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Adventure", color = Color.LightGray, fontSize = 20.sp)
                Text(text = "Drama", color = Color.LightGray, fontSize = 20.sp)
                Text(text = "Thriller", color = Color.LightGray, fontSize = 20.sp)
                Text(text = "Action", color = Color.LightGray, fontSize = 20.sp)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 60.dp, end = 60.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "" )
                    Text(text = "My List", color = Color.White)
                }
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play", color = Color.Black, fontSize = 18.sp)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.ic_info), contentDescription = "")
                    Text(text = "Info", color = Color.White)

                }


            }


        }
    }
}

@Composable
fun addMovieList(movieType:String){
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(top = 20.dp, start = 20.dp, end = 20.dp)) {
        Text(text = movieType,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.LightGray
        )
        LazyRow {
            itemsIndexed(getRandomMovieList()){ index, item ->
                MovieItemUiModel(imageRes = item.image)
            }
        }

    }
}

@Composable
fun MovieItemUiModel(imageRes : Int){
    androidx.compose.foundation.Image(painter = painterResource(id = imageRes), contentDescription = "Movie Name",
        modifier = Modifier
            .height(120.dp)
            .width(170.dp))

}
fun getRandomMovieList(): List<MovieItemModel>{
    val listOfMovies = mutableListOf<MovieItemModel>()
    listOfMovies.add(MovieItemModel(R.drawable.image2))
    listOfMovies.add(MovieItemModel(R.drawable.image3))
    listOfMovies.add(MovieItemModel(R.drawable.image4))
    listOfMovies.add(MovieItemModel(R.drawable.image_7))
        listOfMovies.shuffle()
    return listOfMovies
}

data class MovieItemModel(
    val image: Int
)


