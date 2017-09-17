package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmList
import io.realm.RealmObject

open class IksmResponse(
        open var result: RealmList<OneBattle>? = RealmList()
) : RealmObject() {
}