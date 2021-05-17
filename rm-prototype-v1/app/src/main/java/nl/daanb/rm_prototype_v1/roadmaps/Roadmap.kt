package nl.daanb.rm_prototype_v1.roadmaps

data class Roadmap (
    val title: String,
    var progress: Int = 0,
    val url: String = "placeholderstring"
)