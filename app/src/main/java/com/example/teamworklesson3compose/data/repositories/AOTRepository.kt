package com.example.teamworklesson3compose.data.repositories

import com.example.teamworklesson3compose.data.remote.apiservices.AttackOnTitansApiService
import com.example.teamworklesson3compose.utils.base.BaseRepository
import javax.inject.Inject

class AOTRepository @Inject constructor(
    private val attackOnTitansApiService: AttackOnTitansApiService
) : BaseRepository() {

    suspend fun getCharacters() = doRequest {
        attackOnTitansApiService.getCharacter().results
    }

    suspend fun getTitans() = doRequest {
        attackOnTitansApiService.getTitan().results
    }
}