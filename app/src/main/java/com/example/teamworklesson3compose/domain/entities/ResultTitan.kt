package com.example.teamworklesson3compose.domain.entities


data class ResultTitan(
    val abilities: List<String>,
    val allegiance: String,
    val currentInheritor: String,
    val formerInheritors: List<String>,
    val height: String,
    val id: Int,
    val img: String,
    val name: String
)
