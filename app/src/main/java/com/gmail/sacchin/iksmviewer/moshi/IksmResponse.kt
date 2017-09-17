package com.gmail.sacchin.iksmviewer.moshi

data class IksmResponse(
        var results: List<OneBattle> = ArrayList(),
        var unique_id: String = "",
        var summary: Summary = Summary()
)