package com.example.roadmapp.models

data class Resource(
    val title: String,
    val type: String,
    val img: String = "https://media-exp1.licdn.com/dms/image/C4D0BAQH67gZSHaN1sg/company-logo_200_200/0/1595835439853?e=2159024400&v=beta&t=gMsY5AcY1-NdHJDvc6S8boPFauhBihJRn4LQF3iXH7g",
    var done: Boolean = false
)
