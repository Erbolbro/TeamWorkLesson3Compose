package com.example.teamworklesson3compose

enum class NavigationScreens(val route:String) {

    CHARACTER_SCREEN(route = "characterScreen/{character}"),
    DETAIL_SCREEN(route = "detailScreen")
}