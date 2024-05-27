package com.example.teamworklesson3compose.presentation.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.teamworklesson3compose.domain.entities.Character
import com.example.teamworklesson3compose.domain.entities.ResultTitan
import com.example.teamworklesson3compose.domain.usecases.GetCharactersUseCase
import com.example.teamworklesson3compose.domain.usecases.GetTitansUseCase
import com.example.teamworklesson3compose.domain.usecases.SearchCharactersUseCase
import com.example.teamworklesson3compose.utils.UiState
import com.example.teamworklesson3compose.utils.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AOTViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getTitansUseCase: GetTitansUseCase,
    private val searchCharactersUseCase: SearchCharactersUseCase
) : BaseViewModel() {
    private val _charactersState = MutableLiveData<UiState<List<Character>>>()
    val charactersState: LiveData<UiState<List<Character>>>
        get() = _charactersState

    private val _titansState = MutableLiveData<UiState<List<ResultTitan>>>()
    val titansState: LiveData<UiState<List<ResultTitan>>>
        get() = _titansState

    private val _searchCharactersState = MutableLiveData<UiState<List<Character>>>()
    val searchCharactersState: LiveData<UiState<List<Character>>> get() = _searchCharactersState

    init {
        getCharacters()
        getTitans()
        searchCharacters(name = String())
    }

    private fun getCharacters() {
        viewModelScope.launch {
            getDataShortener(_charactersState, getCharactersUseCase.execute())
        }
    }

    private fun getTitans() {
        viewModelScope.launch {
            getDataShortener(_titansState, getTitansUseCase.execute())
        }
    }

    fun searchCharacters(name: String) {
        viewModelScope.launch {
            getDataShortener(_searchCharactersState, searchCharactersUseCase.execute(name))
        }
    }
}
