package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

open class Gear (
    open var rarity: Int,
    open var image: String,
    open var kind: String,
    open var brand: Brand,
    open var id: Int,
    open var thumbnail: String,
    open var name: String
): RealmObject() {
    constructor(): this(0, "", "", Brand(), 2, "", "") {

    }
}