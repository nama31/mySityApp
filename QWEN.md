# MyCityApp — Контекст проекта

## Обзор проекта

**MyCityApp** — это Android-приложение, разработанное с использованием **Kotlin** и **Jetpack Compose**. Приложение представляет собой справочник городских мест с многоэкранной навигацией, локальными данными и адаптивным UI.

Проект находится в стадии **начальной разработки** — создана структура пакетов и заглушки классов согласно PRD (Product Requirements Document).

## Технологии и стек

| Компонент | Технология |
|-----------|------------|
| Язык | Kotlin |
| UI Toolkit | Jetpack Compose |
| Дизайн | Material 3 |
| Навигация | Navigation Compose |
| Сборка | Gradle (Kotlin DSL) |
| Min SDK | 24 |
| Target SDK | 36 |

## Структура проекта

```
app/src/main/java/com/example/mycityapp/
│
├── MainActivity.kt          # Точка входа приложения
├── MyCityApp.kt             # Основное приложение (заготовка)
│
├── model/
│   ├── Category.kt          # Модель категории (заготовка)
│   └── Place.kt             # Модель места (заготовка)
│
├── data/
│   ├── PlacesRepository.kt      # Интерфейс репозитория (заготовка)
│   ├── LocalPlacesRepository.kt # Локальная реализация (заготовка)
│   └── LocalDataSource.kt       # Источник данных (заготовка)
│
├── ui/
│   ├── state/
│   │   ├── MyCityUiState.kt     # Состояние UI (заготовка)
│   │   └── MyCityScreen.kt      # Компоненты экрана (заготовка)
│   │
│   ├── viewmodel/
│   │   └── MyCityViewModel.kt   # ViewModel (заготовка)
│   │
│   ├── screens/
│   │   ├── CategoryScreen.kt    # Экран категории (заготовка)
│   │   ├── PlacesScreen.kt      # Экран списка мест (заготовка)
│   │   └── PlaceDetailScreen.kt # Экран деталей места (заготовка)
│   │
│   ├── components/
│   │   ├── CategoryCard.kt      # Карточка категории (заготовка)
│   │   ├── PlaceListItem.kt     # Элемент списка мест (заготовка)
│   │   ├── PlaceDetailContent.kt# Контент деталей места (заготовка)
│   │   └── MyCityTopAppBar.kt   # Верхняя панель (заготовка)
│   │
│   └── theme/
│       ├── Color.kt             # Цвета (заготовка)
│       ├── Theme.kt             # Тема (заготовка)
│       └── Type.kt              # Типографика (заготовка)
│
├── navigation/
│   ├── MyCityDestinations.kt    # Маршруты навигации (заготовка)
│   └── MyCityNavHost.kt         # NavHost (заготовка)
│
└── util/
    └── WindowSizeUtils.kt       # Утилиты размеров окна (заготовка)
```

## Сборка и запуск

### Требования
- Android Studio Hedgehog или новее
- JDK 11+
- Android SDK (API 24+)

### Команды

```bash
# Сборка отладочной версии
./gradlew assembleDebug

# Сборка release-версии
./gradlew assembleRelease

# Запуск тестов
./gradlew test

# Запуск instrumented-тестов
./gradlew connectedAndroidTest

# Очистка сборки
./gradlew clean

# Запуск приложения на устройстве/эмуляторе
# (через Android Studio или adb)
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Архитектура

Проект следует **простой архитектуре** с разделением на слои:

- **UI Layer** — Jetpack Compose компоненты, состояние, ViewModel
- **Data Layer** — Репозитории и локальные источники данных
- **Navigation Layer** — Маршрутизация между экранами

### Экраны (согласно PRD)

1. **HomeScreen** — Список категорий (LazyColumn)
2. **CategoryScreen** — Список мест выбранной категории
3. **DetailScreen** — Детали места (название, описание, изображение)

### Маршруты навигации

- `home` — главный экран
- `category/{categoryId}` — экран категории
- `detail/{placeId}` — экран деталей места

## Правила разработки

### Код

- **Стиль Kotlin**: официальный (kotlin.code.style=official)
- **AndroidX**: обязательно использовать
- **Material**: только Material 3
- **Навигация**: только Navigation Compose (без Fragments/Activities для экранов)

### Запрещено

- XML-лейауты для UI
- View system
- Material 2
- Сетевые запросы / Базы данных / Firebase
- Глобальные переменные для состояния
- Статические синглтоны для UI-состояния

### Обязательно

- Scaffold, TopAppBar, LazyColumn, Card
- Переиспользуемые композаблы (CategoryCard, PlaceCard)
- Передача ID через навигацию
- Состояние через `remember` или ViewModel

## Тестирование

- **JUnit** — модульные тесты
- **AndroidX Test** — инструментированные тесты
- **Compose UI Test** — тесты UI компонентов

## Чеклист готовности (из PRD)

- [ ] Используется Jetpack Compose
- [ ] Используется Navigation Compose
- [ ] 3 экрана (Home, Category, Detail)
- [ ] Локальные модели данных
- [ ] Навигация через ID
- [ ] Material 3 UI
- [ ] Нет XML layouts
- [ ] Нет сети / БД
- [ ] Код компилируется
- [ ] Приложение запускается

## Примечания

- Проект создан по спецификации **PRD — My City (AI Execution Spec)**
- Все классы в данный момент представляют собой заглушки и требуют реализации
- Основная логика должна быть реализована согласно README.md
