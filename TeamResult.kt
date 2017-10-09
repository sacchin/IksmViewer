package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class TeamResult (
    var key: String,
    var name: String
): RealmObject() {
    constructor(): this("", "") {

    }
}