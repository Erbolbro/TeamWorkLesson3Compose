package com.example.teamworklesson3compose.data.repositories

import com.example.teamworklesson3compose.data.remote.apiservices.AttackOnTitansApiService
import com.example.teamworklesson3compose.data.remote.models.persons.toDomain
import com.example.teamworklesson3compose.data.remote.models.titans.toDomain
import com.example.teamworklesson3compose.domain.entities.Character
import com.example.teamworklesson3compose.domain.entities.ResultTitan
import com.example.teamworklesson3compose.domain.repository.AOTRepository
import com.example.teamworklesson3compose.utils.Either
import com.example.teamworklesson3compose.utils.base.BaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AOTRepositoryImpl @Inject constructor(
    private val attackOnTitansApiService: AttackOnTitansApiService
) : BaseRepository(), AOTRepository {

    override suspend fun getCharacters(): Flow<Either<Throwable, List<Character>>> =
        doRequest {
            attackOnTitansApiService.getCharacter().results.map { it.toDomain() }
        }

    override suspend fun getTitans(): Flow<Either<Throwable, List<ResultTitan>>> =
        doRequest {
            attackOnTitansApiService.getTitan().results.map { it.toDomain() }
        }

    override suspend fun searchCharacters(name: String): Flow<Either<Throwable, List<Character>>> =
        doRequest {
            attackOnTitansApiService.search(name).results.map { it.toDomain() }
        }
}
