package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Gear(
        @PrimaryKey
        open var id: Int = 0,
        open var rarity: Int = 0,
        open var image: String = "",
        open var kind: String = "",
        open var brand: Brand? = Brand(),
        open var thumbnail: String = "",
        open var name: String = ""
) : RealmObject() {

}