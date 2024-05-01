package com.example.teamworklesson3compose.presentation.utils

 sealed class UiState<out T> {

data object Loading:UiState<Nothing>()
     data class Error(val throwable: Throwable,val message:String? = null):UiState<Nothing>()
     data class  Success<T>(val data :T? = null):UiState<T>()
}