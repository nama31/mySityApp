package com.example.mycityapp.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mycityapp.ui.screens.CategoryScreen
import com.example.mycityapp.ui.screens.HomeScreen
import com.example.mycityapp.ui.screens.PlaceDetailScreen

@Composable
fun MyCityNavHost(
    navController: NavHostController,
    windowSizeClass: WindowSizeClass,
) {
    // Двухпанельный режим для Medium и Expanded ширины
    // Многие устройства (планшеты, ландшафтные телефоны) сообщают Medium, а не Expanded
    val isTwoPane = windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact

    NavHost(
        navController = navController,
        startDestination = MyCityDestinations.HOME
    ) {
        composable(MyCityDestinations.HOME) {
            HomeScreen(
                onCategoryClick = { categoryId ->
                    navController.navigate("${MyCityDestinations.CATEGORY}/$categoryId")
                }
            )
        }
        composable(
            route = MyCityDestinations.CATEGORY_ROUTE,
            arguments = listOf(
                navArgument(MyCityDestinations.CATEGORY_ID_ARG) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString(MyCityDestinations.CATEGORY_ID_ARG) ?: return@composable

            CategoryScreen(
                categoryId = categoryId,
                onPlaceClick = { placeId ->
                    if (!isTwoPane) {
                        navController.navigate("${MyCityDestinations.DETAIL}/$placeId")
                    }
                    // В двухпанельном режиме onPlaceClick обрабатывается внутри CategoryScreen через ViewModel
                },
                onBackClick = {
                    navController.popBackStack()
                },
                isExpandedScreen = isTwoPane,
                windowSizeClass = windowSizeClass
            )
        }
        composable(
            route = MyCityDestinations.DETAIL_ROUTE,
            arguments = listOf(
                navArgument(MyCityDestinations.PLACE_ID_ARG) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString(MyCityDestinations.PLACE_ID_ARG) ?: return@composable
            PlaceDetailScreen(
                placeId = placeId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
