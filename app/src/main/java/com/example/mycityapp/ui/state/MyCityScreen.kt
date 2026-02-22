package com.example.mycityapp.ui.state

/**
 * Вспомогательные функции для работы с состояниями экранов
 */
object MyCityScreen {
    /**
     * Получить название категории по ID
     */
    fun getCategoryTitleById(categoryId: String): String {
        return when (categoryId) {
            "food" -> "Еда и рестораны"
            "parks" -> "Парки и отдых"
            "museums" -> "Музеи и культура"
            "shopping" -> "Шопинг"
            "entertainment" -> "Развлечения"
            else -> "Городские места"
        }
    }
}
