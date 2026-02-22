package com.example.mycityapp.data

import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.Place

object LocalDataSource {
    val categories = listOf(
        CityCategory(id = "food", title = "Еда и рестораны"),
        CityCategory(id = "parks", title = "Парки и отдых"),
        CityCategory(id = "museums", title = "Музеи и культура"),
        CityCategory(id = "shopping", title = "Шопинг"),
        CityCategory(id = "entertainment", title = "Развлечения")
    )

    val places = listOf(
        // Food
        Place(
            id = "food_1",
            categoryId = "food",
            title = "Кафе «Уют»",
            description = "Уютное кафе с домашней кухней и авторскими десертами. Идеальное место для завтрака или обеда с друзьями.",
            imageRes = null
        ),
        Place(
            id = "food_2",
            categoryId = "food",
            title = "Ресторан «Гурман»",
            description = "Ресторан европейской кухни с изысканным меню и винной картой. Живая музыка по выходным.",
            imageRes = null
        ),
        Place(
            id = "food_3",
            categoryId = "food",
            title = "Пиццерия «Италия»",
            description = "Настоящая итальянская пицца из дровяной печи. Свежие ингредиенты и традиционные рецепты.",
            imageRes = null
        ),
        
        // Parks
        Place(
            id = "parks_1",
            categoryId = "parks",
            title = "Центральный парк",
            description = "Большой городской парк с аллеями, прудами и зонами для отдыха. Отличное место для прогулок и пробежек.",
            imageRes = null
        ),
        Place(
            id = "parks_2",
            categoryId = "parks",
            title = "Ботанический сад",
            description = "Уникальная коллекция растений со всего мира. Теплицы, розарий и японский сад.",
            imageRes = null
        ),
        Place(
            id = "parks_3",
            categoryId = "parks",
            title = "Набережная реки",
            description = "Живописная набережная с велодорожками, кафе и смотровыми площадками. Красивые закаты.",
            imageRes = null
        ),
        
        // Museums
        Place(
            id = "museums_1",
            categoryId = "museums",
            title = "Краеведческий музей",
            description = "История города с древнейших времён до наших дней. Уникальные археологические находки.",
            imageRes = null
        ),
        Place(
            id = "museums_2",
            categoryId = "museums",
            title = "Художественная галерея",
            description = "Коллекция русского и зарубежного искусства. Регулярные выставки современных художников.",
            imageRes = null
        ),
        Place(
            id = "museums_3",
            categoryId = "museums",
            title = "Музей науки",
            description = "Интерактивный музей с экспонатами, которые можно трогать. Интересно детям и взрослым.",
            imageRes = null
        ),
        
        // Shopping
        Place(
            id = "shopping_1",
            categoryId = "shopping",
            title = "Торговый центр «Галерея»",
            description = "Крупный торговый центр с магазинами, кинотеатром и фудкортом. Более 200 магазинов.",
            imageRes = null
        ),
        Place(
            id = "shopping_2",
            categoryId = "shopping",
            title = "Старый рынок",
            description = "Традиционный рынок с фермерскими продуктами, сувенирами и ремесленными изделиями.",
            imageRes = null
        ),
        
        // Entertainment
        Place(
            id = "entertainment_1",
            categoryId = "entertainment",
            title = "Театр драмы",
            description = "Старейший театр города с богатой историей. Классические и современные постановки.",
            imageRes = null
        ),
        Place(
            id = "entertainment_2",
            categoryId = "entertainment",
            title = "Концертный зал",
            description = "Главная концертная площадка города. Выступления симфонического оркестра и гастролирующих артистов.",
            imageRes = null
        )
    )
}
