package com.gerpax.superpoderesandroid.data

import com.gerpax.superpoderesandroid.data.local.LocalDataSource
import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import com.gerpax.superpoderesandroid.data.mappers.RemoteToLocalMapper
import com.gerpax.superpoderesandroid.data.remote.RemoteDataSource
import com.gerpax.superpoderesandroid.model.Characters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val remoteToLocalMapper: RemoteToLocalMapper,

    ): Repository {

    override suspend fun getCharacters(): Flow<List<LocalHero>> {
        //if (localDataSource.getHeros().count() == 0) {
        //    val remoteSuperheros = remoteDataSource.getCharacters()
        //    localDataSource.insertHeros(remoteToLocalMapper.mapGetHeroResponse(remoteSuperheros.data!!.results))
        //}
        return localDataSource.getHeros()
    }

    override suspend fun getCharactersId(id: String): Characters {
       return remoteDataSource.getCharactersId(id = id)
    }

    override suspend fun insertHero(hero: LocalHero){
        localDataSource.insertHero(hero)
    }

}