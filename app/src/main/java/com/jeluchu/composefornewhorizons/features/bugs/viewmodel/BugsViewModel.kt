package com.jeluchu.composefornewhorizons.features.bugs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.composefornewhorizons.features.bugs.repository.BugsRepository
import com.jeluchu.jchucomponentscompose.core.extensions.exception.handleFailure
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty
import com.jeluchu.jchucomponentscompose.utils.network.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class BugsViewModel @Inject constructor(
    private val repository: BugsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(BugsState())
    val state: StateFlow<BugsState> = _uiState

    init {
        getBugs()
    }

    fun getBugs() {
        repository.getBugs()
            .onStart { _uiState.value = BugsState(isLoading = true) }
            .onEach {
                when (it) {
                    is Resource.Success -> _uiState.value = BugsState(data = it.data.orEmpty())
                    is Resource.Loading -> _uiState.value = BugsState(isLoading = true)
                    is Resource.Error -> _uiState.value = BugsState(error = it.error.handleFailure())
                }
            }.launchIn(viewModelScope)
    }

    data class BugsState(
        val isLoading: Boolean = false,
        val data: List<BugsItem> = emptyList(),
        val error: String = String.empty()
    )

}