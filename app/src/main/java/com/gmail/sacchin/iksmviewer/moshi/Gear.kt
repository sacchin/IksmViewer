package com.gmail.sacchin.iksmviewer.moshi

data class Gear(
        var rarity: Int = 0,
        var image: String = "",
        var kind: String = "",
        var brand: Brand = Brand(),
        var id: Int = 0,
        var thumbnail: String = "",
        var name: String = ""
)