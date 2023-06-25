package com.gerpax.superpoderesandroid.data.mappers

import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun mapLocalSuperheros(localSuperheros: List<LocalHero>): List<LocalHero> {
        return localSuperheros.map { mapLocalSuperheros(it) }
    }

    fun mapLocalSuperheros(getHerosResponse: LocalHero): LocalHero {
        return LocalHero(
            getHerosResponse.id,
            getHerosResponse.name,
            getHerosResponse.description,
            getHerosResponse.photo,
            getHerosResponse.favorite
        )
    }
}
