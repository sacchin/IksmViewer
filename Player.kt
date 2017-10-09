package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class Player (
    var udemae: Udemae,
    var weapon: Weapon,
    var shoes_skills: GearSkill,
    var nickname: String,
    var clothes_skills: GearSkill,
    var head_skills: GearSkill,
    var head: Gear,
    var principal_id: String,
    var star_rank: Int,
    var shoes: Gear,
    var clothes: Gear,
    var player_rank: Int
    ): RealmObject() {
    constructor(): this(Udemae(), Weapon(), GearSkill(), "", GearSkill(), GearSkill(), Gear(), "", 0, Gear(), Gear(), 0) {

    }
}