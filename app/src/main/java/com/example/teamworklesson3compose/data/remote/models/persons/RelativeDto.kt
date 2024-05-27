package com.example.teamworklesson3compose.data.remote.models.persons

import com.example.teamworklesson3compose.domain.entities.Relative
import com.google.gson.annotations.SerializedName

data class RelativeDto(
    @SerializedName("family")
    val family: String,
    @SerializedName("members")
    val members: List<String>
)
fun RelativeDto.toDomain() =
    Relative(family, members)