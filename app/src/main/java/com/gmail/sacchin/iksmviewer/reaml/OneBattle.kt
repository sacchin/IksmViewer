package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class OneBattle(
        @PrimaryKey
        open var battle_number: String = "",
        open var type: String = "",
        open var start_time: Int = 0,
        open var weapon_paint_point: Int = 0,
        open var player_rank: Int = 0,
        open var other_team_count: Int = 0,
        open var estimate_gachi_power: Int = 0,
        open var elapsed_time: Int = 0,
        open var my_team_count: Int = 0,
        open var star_rank: Int = 0,
        open var udemae: Udemae? = Udemae(),
        open var stage: StageMaster? = StageMaster(),
        open var rule: RuleMaster? = RuleMaster(),
        open var other_team_result: KeyValue? = KeyValue(),
        open var my_team_result: KeyValue? = KeyValue(),
        open var player_result: PlayerResult? = PlayerResult()
) : RealmObject() {
}