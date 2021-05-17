package com.example.roadmapp.home

import android.app.Application
import android.content.Intent
import android.provider.CalendarContract
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import com.example.roadmapp.models.Resource

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var resourceAdapter: ResourceAdapter = ResourceAdapter(mutableListOf(
        Resource("Crash Course", "Video", "https://midloscoop.com/wp-content/uploads/2020/03/crashcourse-vinyl-decal_1060x-757x900.jpg"),
        Resource("Beginner's Guide", "Article", "https://nirvanacph.com/welcome/wp-content/uploads/2014/04/Beginners-guide-for-bullion-coins.jpg"),
        Resource("Developer Notes", "Webpage", "https://pbs.twimg.com/profile_images/1168932726461935621/VRtfrDXq_400x400.png"),
        Resource("Example Project", "PDF", "https://1000logos.net/wp-content/uploads/2018/11/GitHub-logo.png"),
        Resource("Design Patterns", "Video", "https://raw.githubusercontent.com/irontec/android-mvvm-example/master/logo.png"),
        Resource("Programming introduction", "Lecture", "https://media.gcflearnfree.org/content/5e31ca08bc7eff08e4063776_01_29_2020/ProgrammingIllustration.png", true),
        Resource("Android MVVM", "Website", "https://www.ericdecanini.com/wp-content/uploads/2020/04/MVVM-Diagram-1-e1586592892648.png", true),
        Resource("Android Jetpack", "Website", "https://cdn.tz.nl/wp-content/uploads/2018/05/android-jetpa.jpg", true),
        Resource("Kotlin Guide", "Article", "https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png", true),
    ))

    // Prepare intent for exporting to Calendar
    private val calendarIntent = Intent(Intent.ACTION_INSERT).setData(CalendarContract.Events.CONTENT_URI)
        .putExtra(CalendarContract.Events.TITLE, "Work on Roadmap #1")
        .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
        .putExtra(CalendarContract.Events.DESCRIPTION, "Finish at least one task today.")
        .putExtra(CalendarContract.Events.RRULE,"FREQ=WEEKLY;BYDAY=MO")

    // Eport roadmap event to Calendar
    fun exportToCalendar(){
        startActivity(getApplication(), calendarIntent, null)
    }
}