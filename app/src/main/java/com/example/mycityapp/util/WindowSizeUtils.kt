package com.example.mycityapp.util

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

/**
 * Проверка, является ли ширина окна расширенной (планшет/широкий экран)
 */
fun isExpandedWidth(widthSizeClass: WindowWidthSizeClass): Boolean {
    return widthSizeClass == WindowWidthSizeClass.Expanded
}

/**
 * Проверка, является ли ширина окна компактной (телефон)
 */
fun isCompactWidth(widthSizeClass: WindowWidthSizeClass): Boolean {
    return widthSizeClass == WindowWidthSizeClass.Compact
}
