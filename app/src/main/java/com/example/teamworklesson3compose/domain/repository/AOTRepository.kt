package com.example.teamworklesson3compose.domain.repository

import com.example.teamworklesson3compose.data.remote.models.persons.Result
import com.example.teamworklesson3compose.data.remote.models.titans.ResultTitan
import com.example.teamworklesson3compose.utils.Either
import kotlinx.coroutines.flow.Flow

interface AOTRepository {
    suspend fun getCharacters(): Flow<Either<Throwable, List<Result>>>
    suspend fun getTitans(): Flow<Either<Throwable, List<ResultTitan>>>
    suspend fun searchCharacters(name: String): Flow<Either<Throwable, List<Result>>>
}