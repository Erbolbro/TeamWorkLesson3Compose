package com.example.teamworklesson3compose.presentation.data.remote.apiservices

import com.example.teamworklesson3compose.presentation.data.remote.models.persons.PersonsModel
import com.example.teamworklesson3compose.presentation.data.remote.models.titans.TitansModel
import retrofit2.http.GET
import retrofit2.http.Query

private const val TITAN_ENDPOINT = "titans"
private const val CHARACTER_ENDPOINT = "character"
interface AttackOnTitansApiService {

    @GET(TITAN_ENDPOINT)
    suspend fun getTitan(): TitansModel

    @GET(CHARACTER_ENDPOINT)
    suspend fun getCharacter(): PersonsModel

    @GET(CHARACTER_ENDPOINT)
    suspend fun characterSearch(
        @Query("q") query: String
    ): PersonsModel
}