package com.gmail.sacchin.iksmviewer

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.TableRow
import android.widget.TextView
import com.gmail.sacchin.iksmviewer.reaml.OneBattle
import com.gmail.sacchin.iksmviewer.reaml.StageMaster
import kotlinx.android.synthetic.main.content_by_stage.*
import kotlin.properties.Delegates

class ByStageActivity : AppCompatActivity() {
    var databaseHelper by Delegates.notNull<DatabaseHelper>()
    var RULE by Delegates.notNull<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_by_stage)

        RULE = intent.getStringExtra("rule") ?: ""

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.title = RULE
        setSupportActionBar(toolbar)

        val realm = (application as MyApplication).realm
        databaseHelper = DatabaseHelper(realm)

        createTable(databaseHelper.selectAllStage().toList())
    }

    fun settingRow(stage: StageMaster, stageResults: List<OneBattle>, row: TableRow) {

        var ss = "none"
        var aa = "none"
        val victory = resources.getString(R.string.victory)
        val defeat = resources.getString(R.string.defeat)
        stageResults.let { nawabari ->
            val winCount = nawabari.filter { it.my_team_result?.key == victory }.size
            val loseCount = nawabari.filter { it.my_team_result?.key == defeat }.size
            ss = "$winCount/${winCount + loseCount}"
            aa = "${winCount.toFloat().div(winCount + loseCount).times(100).toInt()}%"
        }

        (row.getChildAt(0) as TextView).text = stage.name
        (row.getChildAt(1) as TextView).text = ss
        (row.getChildAt(2) as TextView).text = aa
        (row.getChildAt(3) as Button).apply {
            text = "By Weapon"
            setOnClickListener { moveToWeaponActivity(stage.name) }
        }
    }

    fun createTable(stages: List<StageMaster>) {
        val allBattle = databaseHelper.selectAllBattle().filter { it.rule?.name == RULE }

        stages.filter { it.name.isNotBlank() }.forEach { stage ->
            val key = stage.name
            val ooo = allBattle.filter { it.stage?.name == key }
            if (ooo.isNotEmpty()) {
                getLayoutInflater().inflate(R.layout.stage_row, tableLayout)
                val tr = tableLayout.getChildAt(tableLayout.childCount - 1) as TableRow
                settingRow(stage, ooo, tr)
            }
        }
        tableLayout.invalidate()
    }

    fun moveToWeaponActivity(name: String) {
        val intent = Intent(this, ByWeaponActivity::class.java)
        intent.putExtra("stage", name)
        intent.putExtra("rule", RULE)
        startActivity(intent)
    }

}
