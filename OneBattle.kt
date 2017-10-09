package com.gmail.sacchin.iksmviewer
import io.realm.RealmObject

data class OneBattle (
    var battle_number: String,
    var type: String,
    var stage: Stage,
    var start_time: Int,
    var rule: Rule,
    var weapon_paint_point: Int,
    var player_rank: Int,
    var other_team_count: Int,
    var udemae: Udemae,
    var estimate_gachi_power: Int,
    var game_mode: GameMode,
    var player_result: PlayerResult,
    var other_team_result: TeamResult,
    var elapsed_time: Int,
    var my_team_count: Int,
    var star_rank: Int,
    var my_team_result: TeamResult
): RealmObject() {
    constructor(): this("", "", Stage(), 0, Rule(), 0, 0, 0, Udemae(), 0, GameMode(), PlayerResult(), TeamResult(), 0, 0, 0, TeamResult()) {

    }
}