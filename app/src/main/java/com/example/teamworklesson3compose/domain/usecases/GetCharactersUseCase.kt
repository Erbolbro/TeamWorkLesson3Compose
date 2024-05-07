package com.example.teamworklesson3compose.domain.usecases

import com.example.teamworklesson3compose.domain.entities.Character
import com.example.teamworklesson3compose.domain.repository.AOTRepository
import com.example.teamworklesson3compose.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: AOTRepository) {

    suspend fun execute(): Flow<Either<Throwable, List<Character>>> = repository.getCharacters()
}