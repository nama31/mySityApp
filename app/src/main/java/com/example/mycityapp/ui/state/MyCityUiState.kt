package com.example.mycityapp.ui.state

import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.Place

/**
 * Представление состояния UI для экранов приложения
 */
sealed class MyCityUiState {
    data object Loading : MyCityUiState()
    data class Success(
        val categories: List<CityCategory> = emptyList(),
        val places: List<Place> = emptyList(),
        val place: Place? = null,
        val selectedCategoryId: String? = null,
        val selectedPlaceId: String? = null
    ) : MyCityUiState()
    data class Error(val message: String) : MyCityUiState()
}

/**
 * Состояние для экрана категорий (HomeScreen)
 */
data class HomeUiState(
    val categories: List<CityCategory> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

/**
 * Состояние для экрана мест категории (CategoryScreen/PlacesScreen)
 */
data class CategoryUiState(
    val categoryId: String = "",
    val categoryTitle: String = "",
    val places: List<Place> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

/**
 * Состояние для экрана деталей места (PlaceDetailScreen)
 */
data class PlaceDetailUiState(
    val place: Place? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
