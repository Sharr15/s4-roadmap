package nl.daanb.rm_prototype_v1.achievements

data class Achievement(
        val title: String,
        val points: Int = 5,
        val achieved: Boolean = false
)