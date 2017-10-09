package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class Weapon (
    var image: String,
    var id: Int,
    var special: Skill,
    var sub: Skill,
    var name: String,
    var thumbnail: String
): RealmObject() {
    constructor(): this("", 0, Skill(), Skill(), "", "") {

    }
}