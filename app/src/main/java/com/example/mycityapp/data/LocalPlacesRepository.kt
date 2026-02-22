package com.example.mycityapp.data


import com.example.mycityapp.model.CityCategory
import com.example.mycityapp.model.Place

class LocalPlacesRepository : PlacesRepository {
    override fun getCategories(): List<CityCategory> = LocalDataSource.categories

    override fun getPlacesByCategory(categoryId: String): List<Place> =
        LocalDataSource.places.filter { it.categoryId == categoryId }

    override fun getPlace(placeId: String): Place? =
        LocalDataSource.places.find { it.id == placeId }
}