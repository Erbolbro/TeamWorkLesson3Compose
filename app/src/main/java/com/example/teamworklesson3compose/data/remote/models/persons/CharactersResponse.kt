package com.example.teamworklesson3compose.data.remote.models.persons

import com.google.gson.annotations.SerializedName

data class CharactersResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<T>
)