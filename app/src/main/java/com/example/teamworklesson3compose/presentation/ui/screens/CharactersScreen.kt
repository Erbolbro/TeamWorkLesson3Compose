package com.example.teamworklesson3compose.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.teamworklesson3compose.presentation.data.remote.models.persons.Result
import com.example.teamworklesson3compose.presentation.data.remote.models.titans.ResultTitan
import com.example.teamworklesson3compose.presentation.ui.theme.DarkBlue
import com.example.teamworklesson3compose.presentation.ui.viewmodels.AOTViewModel
import com.example.teamworklesson3compose.presentation.utils.UiState

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    viewModel: AOTViewModel = hiltViewModel()
) {
    val characters by viewModel.charactersState.observeAsState()
    val titans by viewModel.titansState.observeAsState()
    Box(modifier = Modifier.background(color = DarkBlue).padding(4.dp)) {
        Column {
            UserInfo(modifier = Modifier.fillMaxWidth())
            SearchAccount()
            SuggestionsDesign()
            LazyRow(modifier = Modifier) {
                when (titans) {
                    is UiState.Error -> {
                        Log.e("titans", "CharactersScreen: ${(titans as UiState.Error).message}")
                    }

                    is UiState.Loading -> {
                    }

                    is UiState.Success -> {
                        (titans as UiState.Success<List<ResultTitan>>).data?.let {
                            items(it) { item ->
                                LazyRowTitanItem(titans = item)
                            }
                        }
                    }

                    null -> {
                    }
                }
            }
            LazyColumn(modifier = Modifier) {
                when (characters) {
                    is UiState.Error ->
                        Log.e(
                            "characters",
                            "ошибка: ${(characters as UiState.Error).message}"
                        )

                    UiState.Loading -> {
                    }

                    is UiState.Success -> (characters as UiState.Success<List<Result>>).data?.let {
                        items(it) { item ->
                            LazyColumTitanItem(characters = item)
                        }
                    }

                    null -> {

                    }
                }
            }
        }
    }
}