package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Brand(
        @PrimaryKey
        open var id: Int = 0,
        open var name: String = "",
        open var frequent_skill: Contents? = Contents(),
        open var image: String = ""
) : RealmObject() {
}