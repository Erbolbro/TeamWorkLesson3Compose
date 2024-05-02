package com.example.teamworklesson3compose.presentation.ui.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.teamworklesson3compose.data.remote.models.persons.Result
import com.example.teamworklesson3compose.data.remote.models.titans.ResultTitan
import com.example.teamworklesson3compose.data.repositories.AOTRepository
import com.example.teamworklesson3compose.utils.base.BaseViewModel
import com.example.teamworklesson3compose.utils.extensions.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AOTViewModel @Inject constructor(
    private val repository: AOTRepository
) : BaseViewModel() {

    private val _titansState = uiStateLiveData<List<ResultTitan>>()
    val titansState = _titansState.asLiveData()
    private val _charactersState = uiStateLiveData<List<Result>>()
    val charactersState = _charactersState.asLiveData()

    init {
        viewModelScope.launch {
            repository.getCharacters().collectFlowAsState(
                _charactersState
            )
            repository.getTitans().collectFlowAsState(
                _titansState
            )
        }
    }
}