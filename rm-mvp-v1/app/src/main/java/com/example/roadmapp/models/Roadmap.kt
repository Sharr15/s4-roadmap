package com.example.roadmapp.models

data class Roadmap(
    val title: String,
    var resources: List<Resource>,
    val progress: Int = 0
)
