package com.gerpax.superpoderesandroid.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gerpax.superpoderesandroid.ui.details.HeroDetailScreen
import com.gerpax.superpoderesandroid.ui.details.HeroDetailViewModel
import com.gerpax.superpoderesandroid.ui.listaheroes.HeroListScreen
import com.gerpax.superpoderesandroid.ui.listaheroes.HeroListViewModel
import com.gerpax.superpoderesandroid.ui.navigation.Screens.HeroDetailScreen.ARG_ID

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationGraph(heroListViewModel: HeroListViewModel, heroDetailViewModel: HeroDetailViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SuperheroScreen.route) {

        composable(Screens.SuperheroScreen.route) {
            HeroListScreen(viewModel = heroListViewModel, navController = navController)
        }

        composable(Screens.HeroDetailScreen.route,
            arguments = listOf(navArgument( ARG_ID ){
                type = NavType.StringType
            })
        ) {
            val id = it.arguments?.getString(ARG_ID)
            if (id != null) {
                HeroDetailScreen(viewModel = heroDetailViewModel, id
                )
            }
        }
    }
}