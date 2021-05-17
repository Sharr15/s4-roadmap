package com.example.roadmapp.achievements

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.roadmapp.models.Achievement

class AchievementViewModel(application: Application) : AndroidViewModel(application) {
    var achievementAdapter: AchievementAdapter = AchievementAdapter(mutableListOf(
        Achievement("First roadmap", 5, true),
        Achievement("Add more than 5 resources", 5, true),
        Achievement("Add more than 10 resources", 10),
        Achievement("Finish first roadmap", 10),
        Achievement("Export a roadmap", 15),
        Achievement("Share a roadmap", 15, true),
        Achievement("Delete a roadmap", 10, true),
        Achievement("Complete 5 roadmaps", 15),
        Achievement("Edit a roadmap"),
        Achievement("Create an account", 10, true),
        Achievement("Check items 5 days in a row", 5, true),
        Achievement("Check items 10 days in a row", 10),
        Achievement("Check items 15 days in a row", 15),
        Achievement("Complete a roadmap",5,true)
    ))

    var total: String

    init {
        total = achievementAdapter.getTotal().toString()
    }
}