package com.example.teamworklesson3compose.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teamworklesson3compose.data.remote.models.persons.ResultCharacterDto
import com.example.teamworklesson3compose.data.remote.models.titans.ResultTitanDto
import com.example.teamworklesson3compose.domain.entities.Character
import com.example.teamworklesson3compose.presentation.ui.theme.DarkBlue
import com.example.teamworklesson3compose.presentation.ui.viewmodels.AOTViewModel
import com.example.teamworklesson3compose.utils.UiState

@Preview
@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: AOTViewModel = hiltViewModel()
) {
    val characters by viewModel.charactersState.observeAsState()
    val titans by viewModel.titansState.observeAsState()
    val searchCharacter by viewModel.searchCharactersState.observeAsState()
    Box(
        modifier = Modifier
            .background(color = DarkBlue)
            .padding(4.dp)
    ) {
        Column {
            UserInfo(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            SearchAccount()
            when(searchCharacter){
                is UiState.Error -> {
                    Log.e("tag", "CharactersScreen:${(searchCharacter as UiState.Error).message} ", )
                }
                UiState.Loading -> {

                }
                is UiState.Success -> {
                    (searchCharacter as UiState .Success<List<Character>>).data?.let {
                        
                    }
                }
                null -> TODO()
            }

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .padding(6.dp)
            )

            SuggestionsDesign()
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
                    .padding(6.dp)
            )
            LazyRow(modifier = Modifier.padding(4.dp)) {
                when (titans) {
                    is UiState.Error -> {
                        Log.e("titans", "CharactersScreen: ${(titans as UiState.Error).message}")
                    }

                    is UiState.Loading -> {
                    }

                    is UiState.Success -> {
                        (titans as UiState.Success<List<ResultTitanDto>>).data?.let {
                            items(it) { item ->
                                LazyRowTitanItem(titans = item)
                                Spacer(modifier = Modifier.width(12.dp))
                            }
                        }
                    }

                    null -> {
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            TheBestCharacter(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp))

            LazyColumn(modifier = Modifier) {
                when (characters) {
                    is UiState.Error ->
                        Log.e(
                            "characters",
                            "ошибка: ${(characters as UiState.Error).message}"
                        )

                    UiState.Loading -> {
                    }

                    is UiState.Success -> (characters as UiState.Success<List<ResultCharacterDto>>).data?.let {
                        items(it) { item ->
                            LazyColumCharacterItem(characters = item)
                        }
                    }

                    null -> {
                    }
                }
            }
        }
    }
}