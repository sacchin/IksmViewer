package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

open class GameMode (
        open var key: String,
        open var name: String
): RealmObject() {
    constructor(): this("", "") {

    }
}