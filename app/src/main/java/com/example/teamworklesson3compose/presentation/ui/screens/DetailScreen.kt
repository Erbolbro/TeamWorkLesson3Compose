package com.example.teamworklesson3compose.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    backStackEntry: NavBackStackEntry
) {
    val name = backStackEntry.arguments?.getString("name")
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        name?.let {
            Text(text = it, fontSize = 30.sp)
        }
    }
}