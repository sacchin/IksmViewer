package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class Rule (
    var key: String,
    var multiline_name: String,
    var name: String
): RealmObject() {
    constructor(): this("", "", "") {

    }
}