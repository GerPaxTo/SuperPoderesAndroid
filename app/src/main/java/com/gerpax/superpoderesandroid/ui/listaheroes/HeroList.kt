package com.gerpax.superpoderesandroid.ui.listaheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ContentAlpha
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.gerpax.superpoderesandroid.R
import com.gerpax.superpoderesandroid.data.local.model.LocalHero

var tipo: String = ""

@Composable
fun HeroListScreen(viewModel: HeroListViewModel, navController: NavController) {
    val state  by viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getSuperheros()
    }

    HeroListScreenContent( state ) { hero ->
        if (tipo == "Fav") {
            hero.favorite = !hero.favorite
            viewModel.insertHero(hero)
        } else {
            navController.navigate(route = "HeroDetailScreen/" + hero.id)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroListScreenContent(heros: List<LocalHero>, onHeroClicked: (LocalHero) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        MarvelTopBar()
    }) { it ->
        LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp), contentPadding = it){
            items(heros, key = { it.id }){ hero ->
                MarvelHeroItem(hero = hero, onHeroclick = onHeroClicked)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarvelTopBar(){
    CenterAlignedTopAppBar(title = {
        Text(text = "Marvel")
        Image(
            painter = painterResource(id = R.drawable.marvel),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    })
}

@Preview
@Composable
fun MarvelTopBar_Preview(){
    MarvelTopBar()
}

@Composable
fun MarvelHeroItem(hero: LocalHero, modifier: Modifier = Modifier, onHeroclick: (LocalHero) -> Unit ){
    Card(modifier = modifier
        .fillMaxWidth()
        .height(300.dp)) {
        Text(text = hero.name, style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(8.dp))
        AsyncImage(model = hero.photo,
            contentDescription = hero.name,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )

        Row(Modifier.padding(start = 16.dp, end = 24.dp, top = 16.dp)) {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = hero.description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Box(
                Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                    IconButton(onClick = {
                        tipo = "Fav"
                        onHeroclick(hero)
                    }) {
                        if (hero.favorite) {
                            Icon(Icons.Default.Favorite, contentDescription = null, tint = Red)
                        }else{
                            Icon(Icons.Outlined.FavoriteBorder, contentDescription = null, tint = Gray)
                        }
                    }
                    IconButton(onClick = {
                        tipo = "Inf"
                        onHeroclick(hero)
                    }) {
                       Icon(Icons.Default.Info, contentDescription = null, tint = Blue)
                    }

                }
            }
        }

    }
}

@Preview
@Composable
fun MarvelHeroItem_Preview(){
    MarvelHeroItem(LocalHero(1, "Hulk",
        "Super heroe enojón", "",false)){
    }
}

@Preview(showBackground = true)
@Composable
fun HeroListScreen_Preview() {
    HeroListScreenContent(emptyList()) {  }
}
