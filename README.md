# PRD — My City (AI Execution Spec)

## 1. PURPOSE

Generate a fully working **Android app in Kotlin using Jetpack Compose** that demonstrates:

- Multi-screen navigation
    
- List → detail UI flow
    
- Local data source
    
- Adaptive layouts
    
- Material 3 UI
    

This document defines **exactly what the AI MUST do and MUST NOT do**.

---

## 2. TARGET PLATFORM

- OS: Android
    
- Language: Kotlin
    
- UI Toolkit: Jetpack Compose
    
- Navigation: Navigation-Compose
    
- Design System: Material 3
    
- Min SDK: Default Android Studio template (no custom lowering)
    
- Architecture: Simple UI-state + data layer (no overengineering)
    

---

## 3. REQUIRED SCREENS

AI MUST generate these screens:

1. **HomeScreen**
    
    - Shows list of categories
        
    - Uses LazyColumn
        
    - Each item is clickable
        
    - Navigates to CategoryScreen
        
2. **CategoryScreen**
    
    - Shows list of places for selected category
        
    - Uses LazyColumn
        
    - Each item is clickable
        
    - Navigates to DetailScreen
        
3. **DetailScreen**
    
    - Shows:
        
        - Title
            
        - Description
            
        - Image (placeholder or local resource)
            
    - Has back navigation
        

---

## 4. NAVIGATION RULES

AI MUST:

- Use `androidx.navigation.compose`
    
- Define a `NavHost`
    
- Use routes:
    
    - "home"
        
    - "category/{categoryId}"
        
    - "detail/{placeId}"
        
- Use `navController.navigate(...)`
    
- Use `navController.popBackStack()` for back navigation
    

AI MUST NOT:

- Use Activities for each screen
    
- Use Fragments
    
- Hardcode screen switching without Navigation-Compose
    

---

## 5. DATA RULES

AI MUST:

- Create local data models:
    

data class CityCategory(...)  
data class Place(...)

- Store sample data in Kotlin objects or lists
    
- Use IDs to navigate (categoryId, placeId)
    
- Pass IDs via navigation arguments
    

AI MUST NOT:

- Use network
    
- Use database
    
- Use Firebase
    
- Use API calls
    

---

## 6. UI RULES

AI MUST:

- Use:
    
    - `Scaffold`
        
    - `TopAppBar`
        
    - `LazyColumn`
        
    - `Card`
        
    - `Text`
        
    - `Image` (placeholder allowed)
        
- Use Material 3 components
    
- Create reusable composables:
    
    - CategoryCard
        
    - PlaceCard
        

AI MUST NOT:

- Use XML layouts
    
- Use View system
    
- Use deprecated Material (Material2)
    
- Use hardcoded UI in Activity only
    

---

## 7. STATE MANAGEMENT

AI MUST:

- Use simple state holders:
    
    - remember
        
    - or ViewModel (optional but allowed)
        
- Pass selected IDs via navigation
    
- Derive UI from state/data
    

AI MUST NOT:

- Use global mutable variables
    
- Use static singletons for UI state
    
- Ignore state handling
    

---

## 8. PROJECT STRUCTURE (MANDATORY)

AI MUST generate structure similar to:

com.example.mycity/
	│
	├─ MainActivity.kt
	├─ MyCityApp.kt
	│
	├─ model/
	│   ├─ Category.kt
	│   └─ Place.kt
	│
	├─ data/
	│   ├─ PlacesRepository.kt
	│   ├─ LocalPlacesRepository.kt
	│   └─ LocalDataSource.kt
	│
	├─ ui/
	│   ├─ state/
	│   │   ├─ MyCityUiState.kt
	│   │   └─ MyCityScreen.kt
	│   │
	│   ├─ viewmodel/
	│   │   └─ MyCityViewModel.kt
	│   │
	│   ├─ screens/
	│   │   ├─ CategoryScreen.kt
	│   │   ├─ PlacesScreen.kt
	│   │   └─ PlaceDetailScreen.kt
	│   │
	│   ├─ components/
	│   │   ├─ CategoryCard.kt
	│   │   ├─ PlaceListItem.kt
	│   │   ├─ PlaceDetailContent.kt
	│   │   └─ MyCityTopAppBar.kt
	│   │
	│   └─ theme/
	│       ├─ Color.kt
	│       ├─ Theme.kt
	│       └─ Type.kt
	│
	├─ navigation/
	│   ├─ MyCityDestinations.kt
	│   └─ MyCityNavHost.kt
	│
	└─ util/
	    └─ WindowSizeUtils.kt


---

## 9. BEHAVIOR RULES

AI MUST:

- App starts on HomeScreen
    
- Clicking category → opens CategoryScreen
    
- Clicking place → opens DetailScreen
    
- Back button returns to previous screen
    
- App must compile and run
    

AI MUST NOT:

- Leave TODOs
    
- Leave stub functions
    
- Generate incomplete navigation
    
- Generate non-compiling code
    

---

## 10. NON-GOALS (EXPLICITLY FORBIDDEN)

AI MUST NOT implement:

- Authentication
    
- Login / Signup
    
- Maps / GPS
    
- Network requests
    
- Database
    
- User accounts
    
- Settings screen
    
- Animations beyond defaults
    

---

## 11. ACCEPTANCE CHECKLIST (AI MUST PASS ALL)

-  Uses Jetpack Compose only
    
-  Uses Navigation-Compose
    
-  Has 3 screens (Home, Category, Detail)
    
-  Uses local data models
    
-  Navigation works via IDs
    
-  UI uses Material 3
    
-  No XML layouts
    
-  No network / DB
    
-  Code compiles
    
-  App runs
    

---

## 12. OUTPUT REQUIREMENT

AI MUST output:

- Full Kotlin source code
    
- Proper package structure
    
- All required files
    
- Ready-to-run project logic
    
- No pseudocode
