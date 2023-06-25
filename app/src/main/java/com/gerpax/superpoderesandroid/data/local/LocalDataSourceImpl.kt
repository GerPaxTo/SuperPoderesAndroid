package com.gerpax.superpoderesandroid.data.local

import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: SuperheroDAO): LocalDataSource {

    override suspend fun getHeros(): List<LocalHero> {
        return dao.getAll()
    }

    override suspend fun insertHero(localSuperhero: LocalHero){
        dao.insertAllVararg(localSuperhero)
    }

    override suspend fun insertHeros(localSuperheros: List<LocalHero>){
        dao.insertAllList(localSuperheros)

    }

}