package com.gmail.sacchin.iksmviewer.reaml

import io.realm.RealmObject

open class PlayerResult(
        open var player: Player? = Player(),
        open var sort_score: Int = 0,
        open var kill_count: Int = 0,
        open var death_count: Int = 0,
        open var game_paint_point: Int = 0,
        open var special_count: Int = 0,
        open var assist_count: Int = 0
) : RealmObject() {
}