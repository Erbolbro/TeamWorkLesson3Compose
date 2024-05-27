package com.example.teamworklesson3compose.domain.entities

import com.google.gson.annotations.SerializedName

data class Group(
    val name: String,
    val subGroups: List<String>
)
