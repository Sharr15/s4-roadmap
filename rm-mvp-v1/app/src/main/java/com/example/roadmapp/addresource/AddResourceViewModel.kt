package com.example.roadmapp.addresource

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.roadmapp.models.Result

class AddResourceViewModel(application: Application): AndroidViewModel(application) {
    val resultAdapter: ResultAdapter = ResultAdapter(
        mutableListOf(
            Result("Result 1", "Website"),
            Result("Result 2", "Article"),
            Result("Result 3", "Video"),
            Result("Result 4", "PDF"),
            Result("Result 5", "Website"),
            Result("Result 6", "Article"),
        )
    )
}