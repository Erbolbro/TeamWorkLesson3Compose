package com.example.teamworklesson3compose.data.repositories

import com.example.teamworklesson3compose.data.remote.apiservices.AttackOnTitansApiService
import com.example.teamworklesson3compose.data.remote.models.persons.Result
import com.example.teamworklesson3compose.data.remote.models.titans.ResultTitan
import com.example.teamworklesson3compose.domain.repository.AOTRepository
import com.example.teamworklesson3compose.utils.Either
import com.example.teamworklesson3compose.utils.base.BaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AOTRepositoryImpl @Inject constructor(
    private val attackOnTitansApiService: AttackOnTitansApiService
) : BaseRepository(), AOTRepository {

    override suspend fun getCharacters(): Flow<Either<Throwable, List<Result>>> =
        doRequest {
            attackOnTitansApiService.getCharacter().results
        }

    override suspend fun getTitans(): Flow<Either<Throwable, List<ResultTitan>>> =
        doRequest {
            attackOnTitansApiService.getTitan().results
        }

    override suspend fun searchCharacters(name: String): Flow<Either<Throwable, List<Result>>> =
        doRequest {
            attackOnTitansApiService.search(name).results
        }
}
