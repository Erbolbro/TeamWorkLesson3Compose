package com.example.teamworklesson3compose.domain.entities

import com.google.gson.annotations.SerializedName

data class Relative(
    val family: String,
    val members: List<String>
)
