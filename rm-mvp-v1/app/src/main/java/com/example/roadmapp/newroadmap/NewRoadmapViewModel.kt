package com.example.roadmapp.newroadmap

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.roadmapp.models.Resource

class NewRoadmapViewModel(application: Application) : AndroidViewModel(application) {
    val roadmapResourceAdapter: RoadmapResourceAdapter = RoadmapResourceAdapter(mutableListOf(
            Resource("Coroutines", "Video", "https://s3.ap-south-1.amazonaws.com/mindorks-server-uploads/mastering-kotlin-coroutines.png"),
            Resource("Persistence in Android", "Article", "https://jakubpchmiel.com/wp-content/uploads/2020/02/roomthumbnail-800x445.png"),
            Resource("Kotlin Coroutine Jobs", "Webpage", "https://i.ytimg.com/vi/wkMQGbU3tEM/maxresdefault.jpg"),
            Resource("Example Project", "PDF", "https://miro.medium.com/max/4010/1*j9hbjszo0zXS32yhvSkdAQ.jpeg"),
            Resource("Coroutines 2", "Video", "https://s3.ap-south-1.amazonaws.com/mindorks-server-uploads/mastering-kotlin-coroutines.png"),
            Resource("Android Room", "Article", "https://koenig-media.raywenderlich.com/uploads/2018/04/RoomPersistence-feature.png"),
            Resource("Coroutine Jobs", "Webpage", "https://magdamiu.files.wordpress.com/2020/04/coroutines-cooperation-functions.png?w=640"),
            Resource("Example Project 2", "PDF", "https://github.githubassets.com/images/modules/open_graph/github-logo.png"),
    ))
}