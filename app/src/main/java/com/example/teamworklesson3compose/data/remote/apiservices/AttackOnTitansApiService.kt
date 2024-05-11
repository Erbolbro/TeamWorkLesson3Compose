package com.example.teamworklesson3compose.data.remote.apiservices

import com.example.teamworklesson3compose.data.remote.models.persons.CharactersResponse
import com.example.teamworklesson3compose.data.remote.models.persons.ResultCharacterDto
import com.example.teamworklesson3compose.data.remote.models.titans.ResultTitanDto
import com.example.teamworklesson3compose.data.remote.models.titans.TitansResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val TITAN_ENDPOINT = "titans"
private const val CHARACTER_ENDPOINT = "characters"

interface AttackOnTitansApiService {

    @GET(TITAN_ENDPOINT)
    suspend fun getTitan(): TitansResponse<ResultTitanDto>

    @GET(CHARACTER_ENDPOINT)
    suspend fun getCharacter(): CharactersResponse<ResultCharacterDto>

    @GET(CHARACTER_ENDPOINT)
    suspend fun search(
        @Query("name") name: String
    ): CharactersResponse<ResultCharacterDto>
}