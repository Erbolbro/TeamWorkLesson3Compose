package com.example.teamworklesson3compose.utils.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamworklesson3compose.utils.Either
import com.example.teamworklesson3compose.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected open fun <T> getDataShortener(
        state: MutableLiveData<UiState<T>>,
        useCaseFlow: Flow<Either<Throwable, T>>
    ) {
        state.value = UiState.Loading
        viewModelScope.launch {
            try {
                useCaseFlow.collect { result ->
                    when (result) {
                        is Either.Right -> {
                            state.value = UiState.Success(result.right)
                        }
                        is Either.Left -> {
                            state.value = UiState.Error(result.left ?: Exception("Unknown Error"))
                        }
                    }
                }
            } catch (e: Exception) {
                state.value = UiState.Error(e)
            }
        }
    }
}
