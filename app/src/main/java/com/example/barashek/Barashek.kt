package com.example.barashek

import java.io.Serializable

data class Barashek(
    val image: String,
    var isSelected: Boolean = false
) : Serializable
