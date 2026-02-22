package com.example.mycityapp.data


import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.Place

interface PlacesRepository {
    fun getCategories(): List<CityCategory>
    fun getPlacesByCategory(categoryId: String): List<Place>
    fun getPlace(placeId: String): Place?
}