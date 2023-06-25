package com.gerpax.superpoderesandroid.ui.details

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gerpax.superpoderesandroid.R
import com.gerpax.superpoderesandroid.model.Characters
import com.gerpax.superpoderesandroid.model.Comics
import com.gerpax.superpoderesandroid.model.Data
import com.gerpax.superpoderesandroid.model.Events
import com.gerpax.superpoderesandroid.model.Results
import com.gerpax.superpoderesandroid.model.Series
import com.gerpax.superpoderesandroid.model.Stories
import com.gerpax.superpoderesandroid.model.Thumbnail

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HeroDetailScreen(viewModel: HeroDetailViewModel, id:String) {
    val state  by viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getSuperheros(id = id)
    }

    HeroDetailScreenContent ( state ) { heroData ->
        println(heroData)
    }
}

@SuppressLint("SimpleDateFormat")
@Composable
fun HeroDetailScreenContent(heroData: Characters, param: (Any) -> Unit) {
    if (heroData.data!!.results.isNotEmpty()) {
        val hero = heroData.data!!.results[0]
        println(param)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()
                .padding(10.dp)

        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {

                Box {
                    Image(
                        painter = painterResource(id = R.drawable.marvel),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {

                Box {
                    Text(
                        text = hero.name.toString(),
                        color = Color.Blue,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray),

            ) {
                Box {
                    AsyncImage(
                        model = "${hero.thumbnail?.path}.${hero.thumbnail?.extension}",
                        contentDescription = hero.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {

                Box {
                    Text(
                        text = hero.description.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {

                Box {
                    Text(
                        text = "Actualization Date",
                        color = Color.Blue,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {

                Box {
                    Text(
                        text = hero.modified.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(8.dp)
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroDetailScreenContent_Preview() {
    HeroDetailScreenContent(heroData = Characters(0,"","",
        "","","", Data(0,0,
        1,0, listOf(
                Results(0,"Hulk","Muy Enojón","2023-06-22",
                    Thumbnail("",""), "",
                    Comics(0,""),
                    Series(0,""),
                    Stories(0,""),
                    Events(0,""),
                )
            )
        )
    )) {

    }
}