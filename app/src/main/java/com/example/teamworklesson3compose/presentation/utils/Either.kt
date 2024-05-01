package com.example.teamworklesson3compose.presentation.utils

 sealed class Either<out L, out R> {
     data class Left<out L>(val left: L? = null):Either<L,Nothing>()
     data class Right<out R>(val right:R?= null):Either<Nothing,R>()
}