package com.example.mycityapp.navigation

object MyCityDestinations {
    const val HOME = "home"
    const val CATEGORY = "category"
    const val DETAIL = "detail"

    const val CATEGORY_ID_ARG = "categoryId"
    const val PLACE_ID_ARG = "placeId"

    // Полные маршруты для навигации
    const val CATEGORY_ROUTE = "$CATEGORY/{$CATEGORY_ID_ARG}"
    const val DETAIL_ROUTE = "$DETAIL/{$PLACE_ID_ARG}"
}
