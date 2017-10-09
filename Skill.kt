package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class Skill (
    var image_b: String,
    var image_a: String,
    var id: Int,
    var name: String
): RealmObject() {
    constructor(): this("", "", 0, "") {

    }
}