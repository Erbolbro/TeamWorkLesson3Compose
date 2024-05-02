package com.example.teamworklesson3compose.presentation.di

import com.example.teamworklesson3compose.presentation.utils.AppDispatchers
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    fun provideAppDispatchers() = AppDispatchers()
}