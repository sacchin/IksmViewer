package com.gmail.sacchin.iksmviewer.moshi

data class Summary(
        var special_count_average: Float = 0f,
        var count: Int = 0,
        var assist_count_average: Float = 0f,
        var victory_rate: Float = 0f,
        var victory_count: Int = 0,
        var kill_count_average: Float = 0f,
        var defeat_count: Int = 0,
        var death_count_average: Float = 0f
)