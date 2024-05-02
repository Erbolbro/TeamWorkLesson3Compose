package com.example.teamworklesson3compose.data.remote.models.titans


import com.google.gson.annotations.SerializedName

data class ResultTitan(
    @SerializedName("abilities")
    val abilities:List<String>,
    @SerializedName("allegiance")
    val allegiance: String,
    @SerializedName("current_inheritor")
    val currentInheritor: String,
    @SerializedName("former_inheritors")
    val formerInheritors: List<String>,
    @SerializedName("height")
    val height: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String
)