package com.gerpax.superpoderesandroid.ui.navigation

import com.gerpax.superpoderesandroid.ui.navigation.Screens.HeroDetailScreen.ARG_ID

sealed class Screens(val route: String) {
    object SuperheroScreen : Screens(SCREEN2_BASE_ROUTE)
    object HeroDetailScreen : Screens(SCREEN3_BASE_ROUTE){
        const val ARG_ID = "id"
    }

    companion object {
        private const val SCREEN2_BASE_ROUTE = "SuperheroScreen"
        private const val SCREEN3_BASE_ROUTE = "HeroDetailScreen/{$ARG_ID}"
    }
}