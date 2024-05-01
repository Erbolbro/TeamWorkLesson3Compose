package com.example.teamworklesson3compose.presentation.utils

import dagger.hilt.InstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@InstallIn
data class AppDispatchers @Inject constructor(
    val default:CoroutineDispatcher =Dispatchers.Default,
    val io :CoroutineDispatcher = Dispatchers.IO,
    val unconfined:CoroutineDispatcher = Dispatchers.Unconfined
)
