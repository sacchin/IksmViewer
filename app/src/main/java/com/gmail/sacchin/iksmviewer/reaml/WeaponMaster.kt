package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject

open class WeaponMaster(
        open var name: String = "",
        open var drawRange: Float = 0f,
        open var hitRange: Float = 0f,
        open var maxDamage: Float = 0f,
        open var minDamage: Float = 0f
//        open var special: SkillMaster? = SkillMaster(),
//        open var sub: SkillMaster? = SkillMaster()
) : RealmObject() {
}