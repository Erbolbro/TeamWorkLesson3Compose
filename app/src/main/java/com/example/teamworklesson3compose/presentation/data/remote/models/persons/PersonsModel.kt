package com.example.teamworklesson3compose.presentation.data.remote.models.persons

import com.google.gson.annotations.SerializedName

data class PersonsModel(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)