package com.example.mycityapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityapp.ui.components.MyCityTopAppBar
import com.example.mycityapp.ui.components.PlaceDetailContent
import com.example.mycityapp.ui.components.PlaceListItem
import com.example.mycityapp.ui.viewmodel.MyCityViewModel

/**
 * Экран списка мест выбранной категории
 * Поддерживает однопанельный (телефон) и двухпанельный (планшет) режимы
 */
@Composable
fun CategoryScreen(
    categoryId: String,
    onPlaceClick: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    isExpandedScreen: Boolean = false,
    windowSizeClass: WindowSizeClass? = null,
    viewModel: MyCityViewModel = viewModel()
) {
    val uiState by viewModel.categoryUiState.collectAsState()
    val selectedPlaceId by viewModel.selectedPlaceId.collectAsState()

    LaunchedEffect(categoryId) {
        viewModel.loadPlacesForCategory(categoryId)
    }

    // Получаем выбранное место из списка
    val selectedPlace = uiState.places.find { it.id == selectedPlaceId }

    // DEBUG: для отладки раскомментируйте, чтобы видеть состояние на экране
    // val debugInfo = """
    //     DEBUG:
    //     isExpandedScreen=$isExpandedScreen
    //     widthSizeClass=${windowSizeClass?.widthSizeClass ?: "N/A"}
    //     isLoading=${uiState.isLoading}
    //     places.size=${uiState.places.size}
    //     selectedPlaceId=$selectedPlaceId
    //     categoryId=$categoryId
    // """.trimIndent()

    if (isExpandedScreen) {
        // Двухпанельный режим: список слева + детали справа
        Scaffold(
            topBar = {
                MyCityTopAppBar(
                    title = uiState.categoryTitle,
                    showBackButton = true,
                    onBackClick = onBackClick
                )
            }
        ) { innerPadding ->
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // Левая панель: список мест (42% ширины)
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.42f)
                ) {
                    // DEBUG: для отладки раскомментируйте блок Text
                    // Text(
                    //     text = debugInfo,
                    //     style = MaterialTheme.typography.labelSmall,
                    //     color = Color.Red,
                    //     modifier = Modifier
                    //         .fillMaxWidth()
                    //         .background(Color.Yellow)
                    //         .padding(4.dp)
                    // )

                    if (uiState.isLoading) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    } else if (uiState.error != null) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = uiState.error ?: "Ошибка",
                                color = MaterialTheme.colorScheme.error,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    } else if (uiState.places.isEmpty()) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "В этой категории пока нет мест",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(
                                items = uiState.places,
                                key = { it.id }
                            ) { place ->
                                PlaceListItem(
                                    place = place,
                                    onClick = { viewModel.selectPlace(place.id) },
                                    isSelected = place.id == selectedPlaceId
                                )
                            }
                        }
                    }
                }

                // Разделитель между панелями
                VerticalDivider(
                    modifier = Modifier.fillMaxHeight()
                )

                // Правая панель: детали места (58% ширины)
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.58f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedPlace != null) {
                        PlaceDetailContent(
                            place = selectedPlace,
                            enableBackHandler = false,
                            modifier = Modifier.widthIn(max = 700.dp)
                        )
                    } else if (uiState.places.isEmpty()) {
                        Text(
                            text = "В этой категории пока нет мест",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    } else {
                        Text(
                            text = "Выберите место из списка",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    } else {
        // Однопанельный режим: только список
        Scaffold(
            topBar = {
                MyCityTopAppBar(
                    title = uiState.categoryTitle,
                    showBackButton = true,
                    onBackClick = onBackClick
                )
            }
        ) { innerPadding ->
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // DEBUG: для отладки раскомментируйте блок Text
                // Text(
                //     text = debugInfo,
                //     style = MaterialTheme.typography.labelSmall,
                //     color = Color.Red,
                //     modifier = Modifier
                //         .align(Alignment.TopCenter)
                //         .background(Color.Yellow)
                //         .padding(4.dp)
                // )

                when {
                    uiState.isLoading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    uiState.error != null -> {
                        Text(
                            text = uiState.error ?: "Ошибка",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    uiState.places.isEmpty() -> {
                        Text(
                            text = "В этой категории пока нет мест",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    else -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(
                                items = uiState.places,
                                key = { it.id }
                            ) { place ->
                                PlaceListItem(
                                    place = place,
                                    onClick = onPlaceClick
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
