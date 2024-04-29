package com.example.teamworklesson3compose.presentation.remote.models.persons


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("age")
    val age: Int,
    @SerializedName("alias")
    val alias: List<String>,
    @SerializedName("birthplace")
    val birthplace: String,
    @SerializedName("episodes")
    val episodes: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("groups")
    val groups: List<Group>,
    @SerializedName("height")
    val height: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("occupation")
    val occupation: String,
    @SerializedName("relatives")
    val relatives: List<Relative>,
    @SerializedName("residence")
    val residence: String,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("status")
    val status: String
)