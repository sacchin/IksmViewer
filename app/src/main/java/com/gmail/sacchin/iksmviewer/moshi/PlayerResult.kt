package com.gmail.sacchin.iksmviewer.moshi

data class PlayerResult(
        var player: Player = Player(),
        var sort_score: Int = 0,
        var kill_count: Int = 0,
        var death_count: Int = 0,
        var game_paint_point: Int = 0,
        var special_count: Int = 0,
        var assist_count: Int = 0
)