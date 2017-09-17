package com.gmail.sacchin.iksmviewer.moshi

data class GearSkill(
        var main: Contents = Contents(),
        var subs: List<Contents?> = ArrayList()
)