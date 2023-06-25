package com.gerpax.superpoderesandroid.data.mappers

import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import com.gerpax.superpoderesandroid.data.remote.response.GetHerosResponse
import com.gerpax.superpoderesandroid.model.Results
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor(){

    fun mapGetHeroResponse(getHerosResponses: List<Results>): List<LocalHero> {
        return getHerosResponses.map { mapGetHeroResponse(it) }
    }

    fun mapGetHeroResponse(getHerosResponse: Results): LocalHero {
        return LocalHero(getHerosResponse.id!!, getHerosResponse.name!!, getHerosResponse.description!!, "${getHerosResponse.thumbnail?.path}.${getHerosResponse.thumbnail?.extension}",false)
    }
}