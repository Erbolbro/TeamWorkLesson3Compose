package com.example.teamworklesson3compose.data.remote.models.persons

import com.google.gson.annotations.SerializedName

data class Relative(
    @SerializedName("family")
    val family: String,
    @SerializedName("members")
    val members: List<String>
)