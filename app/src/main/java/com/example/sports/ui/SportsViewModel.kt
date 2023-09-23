package com.example.sports.ui

import androidx.lifecycle.ViewModel
import com.example.sports.data.SportsDataSource
import com.example.sports.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SportsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        SportsUiState(
            sportsList = SportsDataSource.getSportsData(),
            currentSport = SportsDataSource.getSportsData().getOrElse(0) {
                SportsDataSource.defaultSport
            }
        )
    )
    val uiState: StateFlow<SportsUiState> = _uiState

    fun updateCurrentSport(selectedSport: Sport) {
        _uiState.update {
            it.copy(currentSport = selectedSport)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }


    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}