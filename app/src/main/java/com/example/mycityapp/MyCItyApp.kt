package com.example.mycityapp

import android.app.Application
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavHostController
import com.example.mycityapp.navigation.MyCityNavHost

/**
 * Основной класс приложения
 */
class MyCityApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Инициализация на уровне приложения
    }
}

/**
 * Композабл верхнего уровня приложения
 * @param windowSizeClass Класс размера окна для адаптивного UI
 * @param navController Контроллер навигации
 */
@androidx.compose.runtime.Composable
fun MyCityApp(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController
) {
    MyCityNavHost(
        navController = navController,
        windowSizeClass = windowSizeClass
    )
}
