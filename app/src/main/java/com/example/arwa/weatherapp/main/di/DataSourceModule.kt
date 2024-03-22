package com.example.arwa.weatherapp.main.di

import com.example.arwa.weatherapp.data.source.local.ILocalDataSource
import com.example.arwa.weatherapp.data.source.local.LocalDataSource
import com.example.arwa.weatherapp.data.source.remote.IRemoteDataSource
import com.example.arwa.weatherapp.data.source.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSource: RemoteDataSource): IRemoteDataSource

    @Binds
    abstract fun bindLocalRemoteDataSource(localDataSource: LocalDataSource): ILocalDataSource

}