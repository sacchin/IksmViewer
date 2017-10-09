package com.gmail.sacchin.iksmviewer

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.realm.Realm
import kotlin.properties.Delegates
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.R.id.edit
import android.databinding.DataBindingUtil


class MainActivity : AppCompatActivity() {
    var databaseHelper by Delegates.notNull<DatabaseHelper>()
    var prefs by Delegates.notNull<SharedPreferences>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)

        val realm = Realm.getDefaultInstance()
        databaseHelper = DatabaseHelper(realm)
        prefs = getSharedPreferences("iksm", Context.MODE_PRIVATE)

        if(prefs.getBoolean("first_launch", false)){
            databaseHelper.insertStages()
            databaseHelper.insertWeapons()
            val editor = prefs.edit()
            editor.putBoolean("first_launch", true)
            editor.apply()
        }
    }

    fun init(){
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.activity_main)
//        val user = User("Test", "User")
//        binding.user = user
//        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.activity_main)
//        val user = User("Test", "User")
//        binding.user = user
//        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.activity_main)
//        val user = User("Test", "User")
//        binding.user = user
//        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.activity_main)
//        val user = User("Test", "User")
//        binding.user = user
        val allBattle = databaseHelper.selectAllBattle()

        allBattle.filter{it.game_mode.name == ""}.let { nawabari ->
            val lose = nawabari.filter { it.my_team_result.name == "" }.size
            val win = nawabari.filter { it.my_team_result.name == "" }.size
        }
        allBattle.filter{it.game_mode.name == ""}.let { area ->
            val lose = area.filter { it.my_team_result.name == "" }.size
            val win = area.filter { it.my_team_result.name == "" }.size
        }
        allBattle.filter{it.game_mode.name == ""}.let { yagura ->
            val lose = yagura.filter { it.my_team_result.name == "" }.size
            val win = yagura.filter { it.my_team_result.name == "" }.size
        }
        allBattle.filter{it.game_mode.name == ""}.let { hoko ->
            val lose = hoko.filter { it.my_team_result.name == "" }.size
            val win = hoko.filter { it.my_team_result.name == "" }.size
        }

    }


    fun moveToStageActivity(){
        val intent = Intent(this, StageActivity::class.java)
        startActivity(intent)
    }
}
