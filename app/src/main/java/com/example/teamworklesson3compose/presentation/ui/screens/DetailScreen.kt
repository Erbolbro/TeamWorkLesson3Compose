package com.example.teamworklesson3compose.presentation.ui.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.teamworklesson3compose.R
import com.example.teamworklesson3compose.domain.entities.Character


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier, character: Character,
    navController: NavController
) {
    Box {
        Card(modifier = Modifier, shape = ShapeDefaults.Medium) {
            Image(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(text = character.name, onTextLayout = {})
                Text(text = character.height, onTextLayout = {})
                Text(text = character.age, onTextLayout = {})
                Text(text = character.gender, onTextLayout = {})
                Text(text = character.birthplace, onTextLayout = {})
                Text(text = character.occupation, onTextLayout = {})
                Text(text = character.residence, onTextLayout = {})
                Text(text = character.status, onTextLayout = {})
            }
        }
    }
}

//@Preview
//@Composable
//fun DetailScreenPreview() {
//    DetailScreen(
//        modifier = Modifier.fillMaxWidth(),
//        navController = NavController(),
//        character = Character(
//            name = "eren",
//            alias = listOf(""),
//            birthplace = "sj",
//            episodes = listOf(""), gender = "sd", groups = listOf(), height = "dsk",
//            id = 0, img = "", occupation = "dsk", age = "sdk", status = "hdsj", residence = "dsjk",
//            species = listOf(""), relatives = listOf(), roles = listOf()
//        )
//    )
//}