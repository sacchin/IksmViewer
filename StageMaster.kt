package com.gmail.sacchin.iksmviewer

import io.realm.RealmObject

open class StageMaster(
    open var name: String
): RealmObject() {
    constructor(): this("") {

    }
}