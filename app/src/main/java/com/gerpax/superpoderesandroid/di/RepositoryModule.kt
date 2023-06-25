package com.gerpax.superpoderesandroid.di

import com.gerpax.superpoderesandroid.data.Repository
import com.gerpax.superpoderesandroid.data.RepositoryImpl
import com.gerpax.superpoderesandroid.data.local.LocalDataSource
import com.gerpax.superpoderesandroid.data.local.LocalDataSourceImpl
import com.gerpax.superpoderesandroid.data.remote.DefaultRemoteDataSource
import com.gerpax.superpoderesandroid.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: DefaultRemoteDataSource): RemoteDataSource
}