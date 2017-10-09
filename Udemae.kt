package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class Udemae (
    var name: String,
    var s_plus_number: String,
    var number: Int
): RealmObject() {
    constructor(): this("", "",  0) {

    }
}