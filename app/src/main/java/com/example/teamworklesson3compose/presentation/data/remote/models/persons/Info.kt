package com.example.teamworklesson3compose.presentation.data.remote.models.persons

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next_page")
    val nextPage: String,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("prev_page")
    val prevPage: Any
)