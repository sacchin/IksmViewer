package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class GearSkill(
        @PrimaryKey
        open var id: String = UUID.randomUUID().toString(),
        open var main: SkillMaster? = SkillMaster(),
        open var subs: RealmList<SkillMaster>? = RealmList()
) : RealmObject() {
}