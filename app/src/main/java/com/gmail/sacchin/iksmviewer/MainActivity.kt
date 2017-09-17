package com.gmail.sacchin.iksmviewer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.gmail.sacchin.iksmviewer.moshi.IksmResponse
import com.gmail.sacchin.iksmviewer.moshi.OneBattle
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    var databaseHelper by Delegates.notNull<DatabaseHelper>()
    var prefs by Delegates.notNull<SharedPreferences>()
    var fileNum by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val realm = (application as MyApplication).realm
        databaseHelper = DatabaseHelper(realm)
        prefs = getSharedPreferences("iksm", Context.MODE_PRIVATE)

        if (prefs.getBoolean("first_launch", true)) {
            databaseHelper.insertStages()
            databaseHelper.insertWeapons()
            databaseHelper.insertRules()
            databaseHelper.insertResults()
            databaseHelper.insertSkills()
            val editor = prefs.edit()
            editor.putBoolean("first_launch", false)
            editor.putInt("file_num", 1)
            editor.apply()
            Log.i("onCreate", "this is first launch.")
        }

        fileNum = prefs.getInt("file_num", 1)
        fab.setOnClickListener {
            asyncDownloadImage()
        }

        nawabari_button.setOnClickListener {
            moveToStageActivity(0)
        }

        area_button.setOnClickListener {
            moveToStageActivity(1)
        }

        yagura_button.setOnClickListener {
            moveToStageActivity(2)
        }

        hoko_button.setOnClickListener {
            moveToStageActivity(3)
        }
        refresh()
    }

    fun refresh() {
        Log.v("selectAllBattle", "refresh")
        num_version.setText("0.0.$fileNum")
        val allBattle = databaseHelper.selectAllBattle()

        val victory = resources.getString(R.string.victory)
        val defeat = resources.getString(R.string.defeat)
        allBattle.filter { it.rule?.name == resources.getString(R.string.nawabari) }.let { nawabari ->
            val winCount = nawabari.filter { it.my_team_result?.key == victory }.size
            val loseCount = nawabari.filter { it.my_team_result?.key == defeat }.size
            nawabari_count.text = "$winCount/${winCount + loseCount}"
            nawabari_win_rate.text = "${winCount.toFloat().div(winCount + loseCount).times(100).toInt()}%"
        }
        allBattle.filter { it.rule?.name == resources.getString(R.string.area) }.let { area ->
            val winCount = area.filter { it.my_team_result?.key == victory }.size
            val loseCount = area.filter { it.my_team_result?.key == defeat }.size
            area_count.text = "$winCount/${winCount + loseCount}"
            area_win_rate.text = "${winCount.toFloat().div(winCount + loseCount).times(100).toInt()}%"
        }
        allBattle.filter { it.rule?.name == resources.getString(R.string.yagura) }.let { yagura ->
            val winCount = yagura.filter { it.my_team_result?.key == victory }.size
            val loseCount = yagura.filter { it.my_team_result?.key == defeat }.size
            yagura_count.text = "$winCount/${winCount + loseCount}"
            yagura_win_rate.text = "${winCount.toFloat().div(winCount + loseCount).times(100).toInt()}%"
        }
        allBattle.filter { it.rule?.name == resources.getString(R.string.hoko) }.let { hoko ->
            val winCount = hoko.filter { it.my_team_result?.key == victory }.size
            val loseCount = hoko.filter { it.my_team_result?.key == defeat }.size
            hoko_count.text = "$winCount/${winCount + loseCount}"
            hoko_win_rate.text = "${winCount.toFloat().div(winCount + loseCount).times(100).toInt()}%"
        }

    }

    fun moveToStageActivity(id: Int) {
        val intent = Intent(this, ByStageActivity::class.java)

        when (id) {
            0 -> intent.putExtra("rule", resources.getString(R.string.nawabari))
            1 -> intent.putExtra("rule", resources.getString(R.string.area))
            2 -> intent.putExtra("rule", resources.getString(R.string.yagura))
            3 -> intent.putExtra("rule", resources.getString(R.string.hoko))
            else -> Log.v("moveToStageActivity", "error")
        }

        startActivity(intent)
    }

    private fun asyncDownloadImage() {
        val asyncTask = S3Helper(this)
        asyncTask.execute("$fileNum.txt")
    }

    fun setResult(result: String) {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(IksmResponse::class.java)

        val iksmList = ArrayList<OneBattle>()
        val dto = adapter.fromJson(result)
        iksmList.addAll(dto.results)

        databaseHelper.insertRecords(iksmList)
        databaseHelper.selectAllBattle().forEach {
            databaseHelper.insertDownloadedFile(it.battle_number)
        }

        val editor = prefs.edit()
        editor.putBoolean("first_launch", false)
        editor.putInt("file_num", fileNum + 1)
        editor.apply()
        fileNum++

        refresh()
    }
}
