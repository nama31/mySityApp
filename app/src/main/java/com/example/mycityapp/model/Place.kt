package com.example.mycityapp.model

import androidx.annotation.DrawableRes

data class Place(
    val id: String,
    val categoryId: String,
    val title: String,
    val description: String,
    @DrawableRes val imageRes: Int? = null
)