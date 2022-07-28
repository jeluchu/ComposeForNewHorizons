package com.jeluchu.composefornewhorizons.features.villagers.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeluchu.composefornewhorizons.features.villagers.models.VillagerItem
import com.jeluchu.composefornewhorizons.features.villagers.repository.VillagersRepository
import com.jeluchu.jchucomponents.core.extensions.exception.handleFailure
import com.jeluchu.jchucomponents.core.extensions.strings.empty
import com.jeluchu.jchucomponents.utils.network.models.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class VillagersViewModel @Inject constructor(
    private val repository: VillagersRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(VillagersState())
    val state: StateFlow<VillagersState> = _uiState

    init {
        getBugs()
    }

    fun getBugs() {
        repository.getVillagers()
            .onStart { _uiState.value = VillagersState(isLoading = true) }
            .onEach {
                when (it) {
                    is Resource.Success -> _uiState.value = VillagersState(data = it.data.orEmpty())
                    is Resource.Loading -> _uiState.value = VillagersState(isLoading = true)
                    is Resource.Error -> _uiState.value =
                        VillagersState(error = it.error.handleFailure())
                }
            }.launchIn(viewModelScope)
    }

    data class VillagersState(
        val isLoading: Boolean = false,
        val data: List<VillagerItem> = emptyList(),
        val error: String = String.empty()
    )

}