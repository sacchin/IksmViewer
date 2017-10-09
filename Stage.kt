package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

open class Stage (
    open var image: String,
    open var id: Int,
    open var name: String
): RealmObject() {
    constructor(): this("", 0, "") {

    }
}