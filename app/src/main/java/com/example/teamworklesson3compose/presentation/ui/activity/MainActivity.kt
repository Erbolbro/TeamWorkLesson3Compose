package com.example.teamworklesson3compose.presentation.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.teamworklesson3compose.NavigationScreens
import com.example.teamworklesson3compose.domain.entities.Character
import com.example.teamworklesson3compose.presentation.ui.screens.CharactersScreen
import com.example.teamworklesson3compose.presentation.ui.screens.DetailScreen
import com.example.teamworklesson3compose.presentation.ui.theme.TeamWorkLesson3ComposeTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeamWorkLesson3ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavigationScreens.CHARACTER_SCREEN.route
                    ) {
                        composable(
                            NavigationScreens.CHARACTER_SCREEN.route
                        ) {
                            CharactersScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }

                        composable(
                            "${NavigationScreens.DETAIL_SCREEN.route}/{character}",
                            arguments = listOf(navArgument("character") {
                                type = NavType.StringType
                                defaultValue = ""
                            })
                        ) { navBackStackEntry ->
                            val characterJson = navBackStackEntry.arguments?.getString("character")
                            val json = characterJson?.replace("?", "/")
                            Log.e("character", "onCreate: $json", )
                            val character = Gson().fromJson(
                                json,
                                Character::class.java
                            )
                            DetailScreen(
                                navController = navController,
                                character = character,
                            )
                        }
                    }
                }
            }
        }
    }
}