package com.jeluchu.composefornewhorizons.features.bugdetails.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeluchu.composefornewhorizons.core.navigation.NavArgs
import com.jeluchu.composefornewhorizons.features.bugdetails.repository.BugDetailRepository
import com.jeluchu.composefornewhorizons.features.bugs.models.BugsItem
import com.jeluchu.jchucomponentscompose.core.extensions.exception.handleFailure
import com.jeluchu.jchucomponentscompose.core.extensions.strings.empty
import com.jeluchu.jchucomponentscompose.utils.network.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class BugDetailViewModel @Inject constructor(
    private val repository: BugDetailRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(BugsState())
    val state: StateFlow<BugsState> = _uiState

    init {
        savedStateHandle.get<String>(NavArgs.BugId.key)?.let { getBug(it) }
    }

    private fun getBug(id: String) {
        repository.getBug(id)
            .onStart { _uiState.value = BugsState(isLoading = true) }
            .onEach {
                when (it) {
                    is Resource.Success -> _uiState.value = BugsState(data = it.data ?: BugsItem.empty())
                    is Resource.Loading -> _uiState.value = BugsState(isLoading = true)
                    is Resource.Error -> _uiState.value =
                        BugsState(error = it.error.handleFailure())
                }
            }.launchIn(viewModelScope)
    }

    data class BugsState(
        val isLoading: Boolean = false,
        val data: BugsItem = BugsItem.empty(),
        val error: String = String.empty()
    )

}