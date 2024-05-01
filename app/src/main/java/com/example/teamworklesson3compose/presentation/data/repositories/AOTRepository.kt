package com.example.teamworklesson3compose.presentation.data.repositories

import com.example.teamworklesson3compose.presentation.data.remote.apiservices.AttackOnTitansApiService
import com.example.teamworklesson3compose.presentation.utils.AppDispatchers
import com.example.teamworklesson3compose.presentation.utils.base.BaseRepository
import javax.inject.Inject

class AOTRepository @Inject constructor(
    private val appDispatchers: AppDispatchers,
    private val attackOnTitansApiService: AttackOnTitansApiService
) : BaseRepository(appDispatchers) {

    suspend fun getCharacters() = doRequest {
        attackOnTitansApiService.getCharacter().results
    }

    suspend fun getTitans() = doRequest {
        attackOnTitansApiService.getTitan().results
    }
}