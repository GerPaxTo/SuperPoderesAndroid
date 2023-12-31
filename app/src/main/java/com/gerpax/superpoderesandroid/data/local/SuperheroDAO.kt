package com.gerpax.superpoderesandroid.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gerpax.superpoderesandroid.data.local.model.LocalHero
import kotlinx.coroutines.flow.Flow

@Dao
interface SuperheroDAO {
    @Query("SELECT * FROM superheros")
    fun getAll(): Flow<List<LocalHero>>

    @Query("SELECT * FROM superheros")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVararg(vararg users: LocalHero)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllList(users: List<LocalHero>)

    @Delete
    suspend fun delete(user: LocalHero)
}