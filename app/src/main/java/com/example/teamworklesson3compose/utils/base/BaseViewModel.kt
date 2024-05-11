package com.example.teamworklesson3compose.utils.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamworklesson3compose.utils.Either
import com.example.teamworklesson3compose.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected open fun <T> Flow<Either<Throwable, T>>.collectFlowAsState(
        state: MutableLiveData<UiState<T>>,
    ) {
        viewModelScope.launch {
            this@collectFlowAsState.collect {
                when (it) {
                    is Either.Left -> {
                        it.left?.let { t ->
                            val message = t.message ?: "Unknown error!"
                            state.value = UiState.Error(t, message)
                        }
                    }

                    is Either.Right -> {
                        it.right?.let { data ->
                            state.value = UiState.Success(data)
                        }
                    }
                }
            }
        }
    }
}