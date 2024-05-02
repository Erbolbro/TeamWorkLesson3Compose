package com.example.teamworklesson3compose.data.remote.models.persons


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("name")
    val name: String,
    @SerializedName("sub_groups")
    val subGroups: List<String>
)