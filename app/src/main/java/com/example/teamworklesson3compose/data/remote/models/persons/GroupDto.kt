package com.example.teamworklesson3compose.data.remote.models.persons

import com.example.teamworklesson3compose.domain.entities.Group
import com.google.gson.annotations.SerializedName

data class GroupDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("sub_groups")
    val subGroups: List<String>
)
fun GroupDto.toDomain() =
    Group(name, subGroups)