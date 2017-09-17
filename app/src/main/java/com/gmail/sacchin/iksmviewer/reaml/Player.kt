package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Player(
        @PrimaryKey
        open var id: String = UUID.randomUUID().toString(),
        open var udemae: Udemae? = Udemae(),
        open var weapon: WeaponMaster? = WeaponMaster(),
        open var shoes_skills: GearSkill? = GearSkill(),
        open var nickname: String = "",
        open var clothes_skills: GearSkill? = GearSkill(),
        open var head_skills: GearSkill? = GearSkill(),
        open var principal_id: String = "",
        open var star_rank: Int = 0,
        //        open var head: Gear? = Gear(),
//        open var shoes: Gear? = Gear(),
//        open var clothes: Gear? = Gear(),
        open var player_rank: Int = 0
) : RealmObject() {
}