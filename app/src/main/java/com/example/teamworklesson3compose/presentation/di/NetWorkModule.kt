package com.example.teamworklesson3compose.presentation.di

import com.example.teamworklesson3compose.presentation.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetWorkModule {

    @Provides
    @Singleton
    fun provideRetrofitClient() = RetrofitClient()

    @Provides
    @Singleton
    fun provideTitanApiService(retrofitClient: RetrofitClient) =
        retrofitClient.titanApiService
}