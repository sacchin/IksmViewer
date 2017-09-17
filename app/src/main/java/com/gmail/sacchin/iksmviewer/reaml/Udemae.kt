package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Udemae(
        @PrimaryKey
        open var id: String = UUID.randomUUID().toString(),
        open var name: String = "",
        open var s_plus_number: String = "",
        open var number: Int = 0
) : RealmObject() {
}