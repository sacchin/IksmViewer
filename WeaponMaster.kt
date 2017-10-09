package com.gmail.sacchin.iksmviewer

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

data class WeaponMaster(
        @PrimaryKey
        var name: String,
        var drawRange: Float,
        var hitRange: Float,
        var maxDamage: Float,
        var minDamage: Float
): RealmObject() {
    constructor(): this("", 0f, 0f, 0f, 0f) {

    }
}