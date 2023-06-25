package com.gerpax.superpoderesandroid.data

import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import com.gerpax.superpoderesandroid.model.Characters
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getCharacters(): List<LocalHero>

    suspend fun getCharactersId(id: String): Characters

    suspend fun insertHero(hero: LocalHero)
}