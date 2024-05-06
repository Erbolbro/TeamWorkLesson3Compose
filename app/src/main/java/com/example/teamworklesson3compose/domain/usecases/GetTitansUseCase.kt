package com.example.teamworklesson3compose.domain.usecases

import com.example.teamworklesson3compose.data.remote.models.titans.ResultTitan
import com.example.teamworklesson3compose.domain.repository.AOTRepository
import com.example.teamworklesson3compose.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTitansUseCase @Inject constructor(private val repository: AOTRepository) {

    suspend fun execute(): Flow<Either<Throwable, List<ResultTitan>>> = repository.getTitans()
}