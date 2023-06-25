package com.gerpax.superpoderesandroid.data.remote
import com.gerpax.superpoderesandroid.model.Characters
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRemoteDataSource @Inject constructor(private val api: MarvelApi) : RemoteDataSource {
    private var apiKey: String = "4f3f0ecd97b20c7cb936d9206a7df955"
    private var ts: String  = "1"
    private var hash: String = "36a714fe2a8b840e258070afefdb6afb"


    override suspend fun getCharacters(): Characters {
        return api.getCharacters(apiKey=apiKey,ts=ts,hash=hash)
    }

    override suspend fun getCharactersId(id: String): Characters {
        return api.getCharactersId(id, apiKey=apiKey,ts=ts,hash=hash)
    }
}