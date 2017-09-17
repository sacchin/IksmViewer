package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Contents(
        @PrimaryKey
        open var id: Int = 0,
        open var name: String = "",
        open var image: String = ""
) : RealmObject() {
}