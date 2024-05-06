package com.example.teamworklesson3compose.domain.usecases

import com.example.teamworklesson3compose.data.remote.models.persons.Result
import com.example.teamworklesson3compose.domain.repository.AOTRepository
import com.example.teamworklesson3compose.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchCharactersUseCase @Inject constructor(private val repository: AOTRepository) {

    suspend fun execute(name: String): Flow<Either<Throwable, List<Result>>> {
        return repository.searchCharacters(name)
    }
}
