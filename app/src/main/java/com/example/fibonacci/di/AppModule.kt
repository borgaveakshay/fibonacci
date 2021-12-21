package com.example.fibonacci.di

import com.example.fibonacci.data_layer.RepositoryImpl
import com.example.fibonacci.domain_layer.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun getRepository(): Repository = RepositoryImpl()
}