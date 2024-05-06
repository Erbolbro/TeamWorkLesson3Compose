package com.example.teamworklesson3compose.di

import com.example.teamworklesson3compose.data.remote.apiservices.AttackOnTitansApiService
import com.example.teamworklesson3compose.data.repositories.AOTRepositoryImpl
import com.example.teamworklesson3compose.domain.repository.AOTRepository
import com.example.teamworklesson3compose.domain.usecases.GetCharactersUseCase
import com.example.teamworklesson3compose.domain.usecases.GetTitansUseCase
import com.example.teamworklesson3compose.domain.usecases.SearchCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCasesModule {

    @Provides
    @Singleton
    fun provideSearchUseCase(aotRepository: AOTRepository): SearchCharactersUseCase {
        return SearchCharactersUseCase(aotRepository)
    }

    @Provides
    @Singleton
    fun provideTitansUseCase(aotRepository: AOTRepository): GetTitansUseCase {
        return GetTitansUseCase(aotRepository)
    }

    @Provides
    @Singleton
    fun provideCharactersUseCase(aotRepository: AOTRepository): GetCharactersUseCase {
        return GetCharactersUseCase(aotRepository)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: AttackOnTitansApiService): AOTRepository {
        return AOTRepositoryImpl(apiService)
    }

}