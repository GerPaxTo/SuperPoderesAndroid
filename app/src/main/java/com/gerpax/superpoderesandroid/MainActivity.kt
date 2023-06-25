package com.gerpax.superpoderesandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gerpax.superpoderesandroid.ui.details.HeroDetailViewModel
import com.gerpax.superpoderesandroid.ui.theme.SuperPoderesAndroidTheme
import com.gerpax.superpoderesandroid.ui.listaheroes.HeroListViewModel
import com.gerpax.superpoderesandroid.ui.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val heroListViewModel: HeroListViewModel by viewModels()
    private val heroDetailViewModel: HeroDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperPoderesAndroidTheme {
                NavigationGraph(heroListViewModel, heroDetailViewModel )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperPoderesAndroidTheme {
        Greeting("Android")
    }
}