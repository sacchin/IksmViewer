package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

open class Contents (
        open var name: String,
        open var id: Int,
        open var image: String
): RealmObject() {
    constructor(): this("", 0, "") {

    }
}