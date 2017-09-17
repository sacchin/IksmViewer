package com.gmail.sacchin.iksmviewer.moshi

data class OneBattle(
        var battle_number: String = "",
        var type: String = "",
        var stage: Stage = Stage(),
        var start_time: Int = 0,
        var rule: Rule = Rule(),
        var weapon_paint_point: Int = 0,
        var player_rank: Int = 0,
        var other_team_count: Int = 0,
        var udemae: Udemae = Udemae(),
        var estimate_gachi_power: Int = 0,
        var player_result: PlayerResult = PlayerResult(),
        var other_team_result: KeyValue = KeyValue(),
        var elapsed_time: Int = 0,
        var my_team_count: Int = 0,
        var star_rank: Int = 0,
        var my_team_result: KeyValue = KeyValue()
) {
    override fun toString(): String {
        return "$udemae, $player_result, $other_team_result, $my_team_result"
    }
}