package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class KeyValue(
        @PrimaryKey
        open var name: String = UUID.randomUUID().toString(),
        open var key: String = ""
) : RealmObject() {
}