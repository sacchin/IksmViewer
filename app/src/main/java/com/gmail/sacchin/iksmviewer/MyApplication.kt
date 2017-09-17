package com.gmail.sacchin.iksmviewer

import android.app.Application
import io.realm.Realm
import kotlin.properties.Delegates

class MyApplication : Application() {
    open var realm: Realm by Delegates.notNull<Realm>()

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        realm = Realm.getDefaultInstance()
    }
}