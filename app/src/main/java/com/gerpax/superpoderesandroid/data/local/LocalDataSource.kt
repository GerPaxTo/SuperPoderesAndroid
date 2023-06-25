package com.gerpax.superpoderesandroid.data.local

import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getHeros(): List<LocalHero>

    suspend fun insertHero(localSuperhero: LocalHero)

    suspend fun insertHeros(localSuperheros: List<LocalHero>)
}