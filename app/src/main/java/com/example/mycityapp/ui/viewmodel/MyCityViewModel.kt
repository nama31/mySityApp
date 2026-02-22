package com.example.mycityapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycityapp.data.LocalPlacesRepository
import com.example.mycityapp.data.PlacesRepository
import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.Place
import com.example.mycityapp.ui.state.CategoryUiState
import com.example.mycityapp.ui.state.HomeUiState
import com.example.mycityapp.ui.state.MyCityScreen
import com.example.mycityapp.ui.state.PlaceDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyCityViewModel(
    private val repository: PlacesRepository = LocalPlacesRepository()
) : ViewModel() {

    // Состояние для HomeScreen
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    // Состояние для CategoryScreen
    private val _categoryUiState = MutableStateFlow(CategoryUiState())
    val categoryUiState: StateFlow<CategoryUiState> = _categoryUiState.asStateFlow()

    // Состояние для PlaceDetailScreen
    private val _placeDetailUiState = MutableStateFlow(PlaceDetailUiState())
    val placeDetailUiState: StateFlow<PlaceDetailUiState> = _placeDetailUiState.asStateFlow()

    // Выбранное место для expanded режима (двухпанельный UI)
    private val _selectedPlaceId = MutableStateFlow<String?>(null)
    val selectedPlaceId: StateFlow<String?> = _selectedPlaceId.asStateFlow()

    init {
        loadCategories()
    }

    /**
     * Загрузить список категорий
     */
    fun loadCategories() {
        _homeUiState.update { it.copy(isLoading = true, error = null) }
        try {
            val categories = repository.getCategories()
            _homeUiState.update {
                it.copy(
                    categories = categories,
                    isLoading = false
                )
            }
        } catch (e: Exception) {
            _homeUiState.update {
                it.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка загрузки категорий"
                )
            }
        }
    }

    /**
     * Загрузить места для выбранной категории
     */
    fun loadPlacesForCategory(categoryId: String) {
        _categoryUiState.update { it.copy(isLoading = true, error = null, categoryId = categoryId) }
        // Сбрасываем выбранное место при загрузке новой категории
        _selectedPlaceId.value = null
        try {
            val category = repository.getCategories().find { it.id == categoryId }
            val places = repository.getPlacesByCategory(categoryId)
            _categoryUiState.update {
                it.copy(
                    categoryTitle = category?.title ?: MyCityScreen.getCategoryTitleById(categoryId),
                    places = places,
                    isLoading = false
                )
            }
            // Автовыбор первого места если список не пуст
            if (places.isNotEmpty()) {
                _selectedPlaceId.value = places.first().id
            }
        } catch (e: Exception) {
            _categoryUiState.update {
                it.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка загрузки мест"
                )
            }
        }
    }

    /**
     * Выбрать место (для expanded режима / двухпанельного UI)
     */
    fun selectPlace(placeId: String) {
        _selectedPlaceId.value = placeId
    }

    /**
     * Загрузить детали места
     */
    fun loadPlaceDetail(placeId: String) {
        _placeDetailUiState.update { it.copy(isLoading = true, error = null) }
        try {
            val place = repository.getPlace(placeId)
            _placeDetailUiState.update {
                it.copy(
                    place = place,
                    isLoading = false
                )
            }
        } catch (e: Exception) {
            _placeDetailUiState.update {
                it.copy(
                    isLoading = false,
                    error = e.message ?: "Ошибка загрузки деталей"
                )
            }
        }
    }

    /**
     * Получить все категории (для прямого доступа)
     */
    fun getCategories(): List<CityCategory> = repository.getCategories()

    /**
     * Получить места по категории (для прямого доступа)
     */
    fun getPlacesByCategory(categoryId: String): List<Place> = repository.getPlacesByCategory(categoryId)

    /**
     * Получить место по ID (для прямого доступа)
     */
    fun getPlace(placeId: String): Place? = repository.getPlace(placeId)
}
