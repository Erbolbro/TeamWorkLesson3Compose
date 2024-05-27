package com.example.teamworklesson3compose.data.remote.models.persons

import com.example.teamworklesson3compose.domain.entities.Character
import com.google.gson.annotations.SerializedName

data class ResultCharacterDto(
    @SerializedName("age")
    val age: String,
    @SerializedName("alias")
    val alias: List<String>,
    @SerializedName("birthplace")
    val birthplace: String,
    @SerializedName("episodes")
    val episodes: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("groups")
    val groups: List<GroupDto>,
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
    val relatives: List<RelativeDto>,
    @SerializedName("residence")
    val residence: String,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("species")
    val species: List<String>,
    @SerializedName("status")
    val status: String
)

fun ResultCharacterDto.toDomain() =
    Character(
        age,
        alias,
        birthplace,
        episodes,
        gender,
        groups.map { it.toDomain() },
        height,
        id,
        img,
        name,
        occupation,
        relatives.map { it.toDomain() },
        residence,
        roles,
        species,
        status
    )