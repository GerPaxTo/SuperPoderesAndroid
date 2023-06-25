package com.gerpax.superpoderesandroid.data.remote

import com.gerpax.superpoderesandroid.model.Characters

interface RemoteDataSource {
    suspend fun getCharacters(): Characters

    suspend fun getCharactersId(id: String): Characters
}