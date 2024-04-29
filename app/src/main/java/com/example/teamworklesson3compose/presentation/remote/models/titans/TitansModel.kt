package com.example.teamworklesson3compose.presentation.remote.models.titans


import com.google.gson.annotations.SerializedName

data class TitansModel(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Result>
)