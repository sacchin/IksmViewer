package com.gmail.sacchin.iksmviewer.moshi

data class Player(
        var udemae: Udemae = Udemae(),
        var weapon: Weapon = Weapon(),
        var shoes_skills: GearSkill = GearSkill(),
        var nickname: String = "",
        var clothes_skills: GearSkill = GearSkill(),
        var head_skills: GearSkill = GearSkill(),
        var head: Gear = Gear(),
        var principal_id: String = "",
        var star_rank: Int = 0,
        var shoes: Gear = Gear(),
        var clothes: Gear = Gear(),
        var player_rank: Int = 0
)