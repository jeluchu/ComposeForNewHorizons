package com.jeluchu.composefornewhorizons.features.bugs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeluchu.inook.features.art.models.art.Art
import com.jeluchu.inook.features.art.repository.ArtsRepository
import com.jeluchu.jchucomponentscompose.core.extensions.exception.handleFailure
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty
import com.jeluchu.jchucomponentscompose.utils.network.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class BugsViewModel @Inject constructor(
    private val repository: ArtsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ArtState())
    val state: StateFlow<ArtState> = _uiState

    init {
        getArts()
    }

    fun getArts() {
        repository.getArts()
            .onStart { _uiState.value = ArtState(isLoading = true) }
            .onEach {
                when (it) {
                    is Resource.Success -> _uiState.value = ArtState(
                        data = it.data.orEmpty(),
                        isFloatButtom = it.data.orEmpty().isNotEmpty()
                    )
                    is Resource.Loading -> _uiState.value = ArtState(isLoading = true)
                    is Resource.Error -> _uiState.value = ArtState(error = it.error.handleFailure())
                }
            }.launchIn(viewModelScope)
    }

    data class ArtState(
        val isLoading: Boolean = false,
        val data: List<Art> = emptyList(),
        val isFloatButtom: Boolean = false,
        val error: String = String.empty()
    )

}