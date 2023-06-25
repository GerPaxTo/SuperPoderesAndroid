package com.gerpax.superpoderesandroid.data.remote


import com.gerpax.superpoderesandroid.model.Characters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ): Characters

    @GET("/v1/public/characters/{id}")
    suspend fun getCharactersId(
        @Path("id") id: String,
        @Query("apikey") apiKey: String,
        @Query("ts") ts: String,
        @Query("hash") hash: String
    ): Characters
}