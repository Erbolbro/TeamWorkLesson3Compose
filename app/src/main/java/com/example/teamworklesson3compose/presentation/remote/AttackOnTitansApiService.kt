package com.example.teamworklesson3compose.presentation.remote

import com.example.teamworklesson3compose.presentation.remote.models.persons.PersonsModel
import com.example.teamworklesson3compose.presentation.remote.models.titans.TitansModel
import retrofit2.http.GET
import retrofit2.http.Query

private const val TITAN_ENDPOINT = "titans"
private const val CHARACTER_ENDPOINT = "character"

interface AttackOnTitansApiService {

    @GET(TITAN_ENDPOINT)
    fun getTitan(): TitansModel

    @GET(CHARACTER_ENDPOINT)
    fun getCharacter(): PersonsModel

    @GET(CHARACTER_ENDPOINT)
    fun characterSearch(
        @Query("q") query: String
    ): PersonsModel
}