package com.example.sports.ui

import com.example.sports.data.SportsDataSource
import com.example.sports.model.Sport

data class SportsUiState(
    val sportsList: List<Sport> = emptyList(),
    val currentSport: Sport = SportsDataSource.defaultSport,
    val isShowingListPage: Boolean = true
)
