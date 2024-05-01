package com.example.teamworklesson3compose.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.teamworklesson3compose.R
import com.example.teamworklesson3compose.presentation.data.remote.models.persons.Result
import com.example.teamworklesson3compose.presentation.ui.theme.Black30
import com.example.teamworklesson3compose.presentation.ui.theme.TeamWorkLesson3ComposeTheme

@Composable
fun CharactersList(
    modifier: Modifier = Modifier,
    gridState: LazyGridState = rememberLazyGridState(),
    characters: List<Result>? = null
) {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    Column(modifier = modifier) {
        TextField(
            modifier = Modifier.fillMaxWidth(), value = text, onValueChange = {
                text = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(
                        R.string.search_icon_content_description
                    ),
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        text = ""
                    },
                    imageVector = Icons.Filled.Clear,
                    contentDescription = stringResource(R.string.clear_text_icon_content_description),
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                focusedContainerColor = Black30,
                unfocusedContainerColor = Black30,
                cursorColor = Color.Black,
            )
        )

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            state = gridState,
            columns = GridCells.Fixed(2)
        ) {
            characters?.let {
                items(it) { character ->
                    CharacterItem(character = character)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharactersList() {
    TeamWorkLesson3ComposeTheme {
        CharactersList(
            modifier = Modifier.fillMaxSize(),
            characters = listOf(),
        )
    }
}