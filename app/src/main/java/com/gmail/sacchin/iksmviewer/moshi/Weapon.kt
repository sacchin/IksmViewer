package com.gmail.sacchin.iksmviewer.moshi

data class Weapon(
        var image: String = "",
        var id: Int = 0,
        var special: Skill = Skill(),
        var sub: Skill = Skill(),
        var name: String = "",
        var thumbnail: String = ""
)