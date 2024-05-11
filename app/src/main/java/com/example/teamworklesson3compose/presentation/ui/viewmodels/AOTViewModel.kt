package com.example.teamworklesson3compose.presentation.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.teamworklesson3compose.domain.entities.Character
import com.example.teamworklesson3compose.domain.entities.ResultTitan
import com.example.teamworklesson3compose.domain.usecases.GetCharactersUseCase
import com.example.teamworklesson3compose.domain.usecases.GetTitansUseCase
import com.example.teamworklesson3compose.domain.usecases.SearchCharactersUseCase
import com.example.teamworklesson3compose.utils.Either
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
        viewModelScope.launch {
            getCharacters()
            getTitans()
            searchCharacters(name = String())
        }
    }

    private fun getCharacters() {
        _charactersState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val result = getCharactersUseCase.execute()
                result.collect { gottenResult ->
                    when (gottenResult) {
                        is Either.Right -> {
                            _charactersState.value = UiState.Success(gottenResult.right)
                        }

                        is Either.Left -> {
                            _charactersState.value =
                                UiState.Error(gottenResult.left ?: Exception("Unknown Error"))
                        }
                    }
                }
            } catch (e: Exception) {
                _charactersState.value = UiState.Error(e)
            }
        }
    }

    private fun getTitans() {
        _titansState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val result = getTitansUseCase.execute()
                result.collect { gottenResult ->

                    when (gottenResult) {
                        is Either.Right -> {
                            _titansState.value = UiState.Success(gottenResult.right)
                        }

                        is Either.Left -> {
                            _titansState.value =
                                UiState.Error(gottenResult.left ?: Exception("Unknown Error"))
                        }
                    }
                }
            } catch (e: Exception) {
                _titansState.value = UiState.Error(e)
            }
        }
    }

    fun searchCharacters(name: String) {
        viewModelScope.launch {
            _searchCharactersState.value = UiState.Loading
            try {
                val result = searchCharactersUseCase.execute(name)
                result.collect { gottenResult ->
                    when (gottenResult) {
                        is Either.Right -> {
                            _searchCharactersState.value = UiState.Success(gottenResult.right)
                        }

                        is Either.Left -> {
                            _searchCharactersState.value =
                                UiState.Error(gottenResult.left ?: Exception("Unknown Error"))
                        }
                    }
                }
            } catch (e: Exception) {
                _searchCharactersState.value = UiState.Error(e)
            }
        }
    }
}