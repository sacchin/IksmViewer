package com.gmail.sacchin.iksmviewer

import io.realm.RealmObject

data class GearSkill (
    var main: Contents,
    var subs: List<Contents>
): RealmObject() {
    constructor(): this(Contents(), ArrayList<Contents>()) {

    }
}