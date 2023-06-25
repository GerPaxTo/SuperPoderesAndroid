package com.gerpax.superpoderesandroid.data.remote
import com.gerpax.superpoderesandroid.BuildConfig
import com.gerpax.superpoderesandroid.model.Characters
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRemoteDataSource @Inject constructor(private val api: MarvelApi) : RemoteDataSource {
    private var apiKey = BuildConfig.API_KEY
    private var ts: String  = "1"
    private var hash: String =BuildConfig.HASH


    override suspend fun getCharacters(): Characters {
        return api.getCharacters(apiKey=apiKey,ts=ts,hash=hash)
    }

    override suspend fun getCharactersId(id: String): Characters {
        return api.getCharactersId(id, apiKey=apiKey,ts=ts,hash=hash)
    }
}