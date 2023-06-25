package com.gerpax.superpoderesandroid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gerpax.superpoderesandroid.data.local.model.LocalHero

@Database(entities = [LocalHero::class], version = 1)
abstract class SuperheroDatabase : RoomDatabase() {
    abstract fun superheroDao(): SuperheroDAO
}