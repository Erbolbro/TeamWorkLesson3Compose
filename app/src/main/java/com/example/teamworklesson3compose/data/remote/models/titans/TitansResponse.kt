package com.example.teamworklesson3compose.data.remote.models.titans

import com.google.gson.annotations.SerializedName

data class TitansResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<T>
)