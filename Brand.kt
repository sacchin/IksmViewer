package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

class Brand (
        var name: String,
        var frequent_skill: Contents,
        var id: Int,
        var image: String
) : RealmObject() {
    constructor(): this("", Contents(), 0, "") {

    }
}