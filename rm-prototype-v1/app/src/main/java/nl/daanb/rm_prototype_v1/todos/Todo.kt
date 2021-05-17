package nl.daanb.rm_prototype_v1.todos

data class Todo (
    val title: String,
    val type: String = "video",
    var checked: Boolean = false,
    val imageUrl: String = "http"
)