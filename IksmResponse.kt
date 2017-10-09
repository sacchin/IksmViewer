package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class IksmResponse(
        var result: List<OneBattle>
): RealmObject() {
    constructor(): this(ArrayList<OneBattle>()) {

    }
}