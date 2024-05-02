package com.example.teamworklesson3compose.data.remote.apiservices

import com.example.teamworklesson3compose.data.remote.models.persons.CharactersResponse
import com.example.teamworklesson3compose.data.remote.models.persons.Result
import com.example.teamworklesson3compose.data.remote.models.titans.ResultTitan
import com.example.teamworklesson3compose.data.remote.models.titans.TitansResponse
import retrofit2.http.GET

private const val TITAN_ENDPOINT = "titans"
private const val CHARACTER_ENDPOINT = "characters"

interface AttackOnTitansApiService {

    @GET(TITAN_ENDPOINT)
    suspend fun getTitan(): TitansResponse<ResultTitan>

    @GET(CHARACTER_ENDPOINT)
    suspend fun getCharacter(): CharactersResponse<Result>
}