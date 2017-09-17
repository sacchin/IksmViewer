package com.gmail.sacchin.iksmviewer.moshi

data class Brand(
        var name: String = "",
        var frequent_skill: Contents = Contents(),
        var id: Int = 0,
        var image: String = ""
)