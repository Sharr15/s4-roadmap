package com.example.roadmapp.models

data class Achievement(
    val title: String,
    val points: Int = 5,
    val achieved: Boolean = false
)
