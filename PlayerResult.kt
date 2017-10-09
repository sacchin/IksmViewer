package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class PlayerResult (
    var player: List<Player>,
    var sort_score: Int,
    var kill_count: Int,
    var death_count: Int,
    var game_paint_point: Int,
    var special_count: Int,
    var assist_count: Int
    ): RealmObject() {
    constructor(): this(ArrayList<Player>(), 0, 0, 0, 0, 0, 0) {

    }
}