package com.gmail.sacchin.iksmviewer

import com.gmail.sacchin.iksmviewer.reaml.*
import io.realm.Realm
import io.realm.RealmResults
import java.util.*

class DatabaseHelper(val realm: Realm) {

    fun selectSkillByName(name: String): SkillMaster? {
        val result = realm.where(SkillMaster::class.java).equalTo("name", name).findFirst()
        return result ?: realm.where(SkillMaster::class.java).equalTo("name", "none").findFirst()
    }

    fun selectWeaponByName(name: String): WeaponMaster? = realm.where(WeaponMaster::class.java).equalTo("name", name).findFirst()
    fun selectResultsByKey(key: String): KeyValue? = realm.where(KeyValue::class.java).equalTo("key", key).findFirst()
    fun selectStageByName(name: String): StageMaster? = realm.where(StageMaster::class.java).equalTo("name", name).findFirst()
    fun selectRuleByName(name: String): RuleMaster? = realm.where(RuleMaster::class.java).equalTo("name", name).findFirst()
    fun selectAllBattle(): RealmResults<OneBattle> = realm.where(OneBattle::class.java).findAll()
    fun selectAllDone(): RealmResults<Done> = realm.where(Done::class.java).findAll()
    fun selectAllStage(): RealmResults<StageMaster> = realm.where(StageMaster::class.java).findAll()
    fun selectAllWeapon(): RealmResults<WeaponMaster> = realm.where(WeaponMaster::class.java).findAll()

    fun insertRecords(records: ArrayList<com.gmail.sacchin.iksmviewer.moshi.OneBattle>) {

        val done = selectAllDone()
        val filtered = records.filter { record ->
            var contains = true
            done.forEach { if (it.name == record.battle_number) contains = false }
            contains
        }

        filtered.forEach { record ->
            realm.executeTransaction {
                //Log.v("insertRecords", record.toString())
                val todoModel = it.createObject(OneBattle::class.java, record.battle_number)
                todoModel.type = record.type
                todoModel.start_time = record.start_time
                todoModel.weapon_paint_point = record.weapon_paint_point
                todoModel.player_rank = record.player_rank
                todoModel.other_team_count = record.other_team_count
                todoModel.estimate_gachi_power = record.estimate_gachi_power
                todoModel.elapsed_time = record.elapsed_time
                todoModel.my_team_count = record.my_team_count
                todoModel.star_rank = record.star_rank
                todoModel.stage = selectStageByName(record.stage.name)
                todoModel.rule = selectRuleByName(record.rule.name)
                todoModel.udemae = insertUdemae(record.udemae)
                todoModel.other_team_result = selectResultsByKey(record.other_team_result.key)
                todoModel.my_team_result = selectResultsByKey(record.my_team_result.key)
                todoModel.player_result = insertPlayerResult(record.player_result, todoModel.udemae!!)
                it.copyToRealm(todoModel)
            }
        }
    }

    fun insertUdemae(record: com.gmail.sacchin.iksmviewer.moshi.Udemae): Udemae {
        val id = UUID.randomUUID()
        val tmp = realm.createObject(Udemae::class.java, id.toString())
        tmp.name = if (record.name.isNullOrBlank()) "none" else record.name
        tmp.number = record.number
        tmp.s_plus_number = if (record.s_plus_number.isNullOrBlank()) "0" else record.s_plus_number.toString()
        realm.copyToRealm(tmp)

        return tmp
    }

    fun insertContents(record: com.gmail.sacchin.iksmviewer.moshi.Contents): Contents {
        var tmp: Contents = Contents()
        realm.executeTransaction {
            tmp = it.createObject(Contents::class.java, record.id)
            tmp.image = record.image
            tmp.name = record.name
            it.copyToRealm(tmp)
        }
        return tmp
    }

    fun insertKeyValue(record: com.gmail.sacchin.iksmviewer.moshi.KeyValue): KeyValue {
        var tmp: KeyValue = KeyValue()
        realm.executeTransaction {
            tmp = it.createObject(KeyValue::class.java, record.name)
            tmp.key = record.key
            it.copyToRealm(tmp)
        }
        return tmp
    }

    fun insertPlayerResult(record: com.gmail.sacchin.iksmviewer.moshi.PlayerResult, udemae: Udemae): PlayerResult {
        val tmp = realm.createObject(PlayerResult::class.java)
        tmp.sort_score = record.sort_score
        tmp.player = insertPlayer(record.player, udemae)
        tmp.kill_count = record.kill_count
        tmp.death_count = record.death_count
        tmp.game_paint_point = record.game_paint_point
        tmp.special_count = record.special_count
        tmp.kill_count = record.assist_count
        realm.copyToRealm(tmp)
        return tmp
    }

    fun insertPlayer(record: com.gmail.sacchin.iksmviewer.moshi.Player, udemae: Udemae): Player {
        val id = UUID.randomUUID().toString()
        val tmp = realm.createObject(Player::class.java, id)
        tmp.nickname = record.nickname
        tmp.principal_id = record.principal_id
        tmp.star_rank = record.star_rank
        tmp.player_rank = record.player_rank
        tmp.udemae = udemae
        tmp.weapon = selectWeaponByName(record.weapon.name)
        tmp.shoes_skills = insertGearSkill(record.shoes_skills)
        tmp.clothes_skills = insertGearSkill(record.clothes_skills)
        tmp.head_skills = insertGearSkill(record.head_skills)
        realm.copyToRealm(tmp)
        return tmp
    }

    fun insertGearSkill(record: com.gmail.sacchin.iksmviewer.moshi.GearSkill): GearSkill {
        val id = UUID.randomUUID()
        val tmp = realm.createObject(GearSkill::class.java, id.toString())
        tmp.main = selectSkillByName(record.main.name)
        record.subs.filter { it != null }.forEach {
            //Log.v("insertGearSkill", "$it")
            it?.let { tmp.subs?.add(selectSkillByName(it.name)) }
        }
        realm.copyToRealm(tmp)
        return tmp
    }

    fun insertDownloadedFile(name: String) {
        realm.executeTransaction {
            val todoModel = it.createObject(Done::class.java)
            todoModel.name = name
            it.copyToRealm(todoModel)
        }
    }

    fun insertStages() {
        realm.executeTransaction {
            val todoModel1 = it.createObject(StageMaster::class.java)
            todoModel1.name = "チョウザメ造船"
            val todoModel2 = it.createObject(StageMaster::class.java)
            todoModel2.name = "ホッケふ頭"
            val todoModel3 = it.createObject(StageMaster::class.java)
            todoModel3.name = "バッテラストリート"
            val todoModel4 = it.createObject(StageMaster::class.java)
            todoModel4.name = "海女美術大学"
            val todoModel5 = it.createObject(StageMaster::class.java)
            todoModel5.name = "ガンガゼ野外音楽堂"
            val todoModel6 = it.createObject(StageMaster::class.java)
            todoModel6.name = "コンブトラック"
            val todoModel7 = it.createObject(StageMaster::class.java)
            todoModel7.name = "フジツボスポーツクラブ"
            val todoModel8 = it.createObject(StageMaster::class.java)
            todoModel8.name = "タチウオパーキング"
            val todoModel9 = it.createObject(StageMaster::class.java)
            todoModel9.name = "マンタマリア号"
            val todoModel10 = it.createObject(StageMaster::class.java)
            todoModel10.name = "モズク農園"
            val todoModel11 = it.createObject(StageMaster::class.java)
            todoModel11.name = "エンガワ河川敷"

            it.copyToRealm(todoModel1)
            it.copyToRealm(todoModel2)
            it.copyToRealm(todoModel3)
            it.copyToRealm(todoModel4)
            it.copyToRealm(todoModel5)
            it.copyToRealm(todoModel6)
            it.copyToRealm(todoModel7)
            it.copyToRealm(todoModel8)
            it.copyToRealm(todoModel9)
            it.copyToRealm(todoModel10)
            it.copyToRealm(todoModel11)
        }
    }


    fun insertRules() {
        realm.executeTransaction {
            val todoModel1 = it.createObject(RuleMaster::class.java)
            todoModel1.name = "ナワバリバトル"
            val todoModel2 = it.createObject(RuleMaster::class.java)
            todoModel2.name = "ガチエリア"
            val todoModel3 = it.createObject(RuleMaster::class.java)
            todoModel3.name = "ガチヤグラ"
            val todoModel4 = it.createObject(RuleMaster::class.java)
            todoModel4.name = "ガチホコバトル"
            it.copyToRealm(todoModel1)
            it.copyToRealm(todoModel2)
            it.copyToRealm(todoModel3)
            it.copyToRealm(todoModel4)
        }
    }

    fun insertResults() {
        realm.executeTransaction {
            val todoModel1 = it.createObject(KeyValue::class.java, "LOSE…")
            todoModel1.key = "defeat"
            val todoModel2 = it.createObject(KeyValue::class.java, "WIN!")
            todoModel2.key = "victory"
            it.copyToRealm(todoModel1)
            it.copyToRealm(todoModel2)
        }
    }

    fun insertWeapons() {
        //name, paint, attack, max, min
        insertWeapon("パラシェルター", 3.3f, 2.5f, 90f, 12.9f)
        insertWeapon("キャンピングシェルター", 4.0f, 1.5f, 120f, 30.0f)
        insertWeapon("スパッタリー", 2.9f, 2f, 36f, 18f)
        insertWeapon("スプラマニューバー", 3.5f, 2.5f, 28f, 15.8f)
        insertWeapon("スプラマニューバーコラボ", 3.5f, 2.5f, 28f, 15.8f)
        insertWeapon("デュアルスイーパー", 4.3f, 3.5f, 28f, 20.2f)
        insertWeapon(".52ガロン", 3.5f, 2.5f, 52f, 39f)
        insertWeapon(".96ガロン", 4.5f, 3.4f, 52f, 37.4f)
        insertWeapon("H3リールガン", 4.5f, 3.4f, 41f, 29.5f)
        insertWeapon("L3リールガン", 4.1f, 3.1f, 29f, 21.8f)
        insertWeapon("N-ZAP85", 3.5f, 2.6f, 28f, 21f)
        insertWeapon("ジェットスイーパー", 5.4f, 4.6f, 32f, 21f)
        insertWeapon("シャープマーカー", 3.2f, 2.2f, 28f, 20.2f)
        insertWeapon("ボールドマーカー", 2.8f, 1.6f, 38f, 30.9f)
        insertWeapon("スプラシューター", 3.5f, 2.6f, 35f, 26.3f)
        insertWeapon("スプラシューターコラボ", 3.5f, 2.6f, 35f, 26.3f)
        insertWeapon("プライムシューター", 4.3f, 3.4f, 42f, 30.2f)
        insertWeapon("プライムシューターコラボ", 4.3f, 3.4f, 42f, 30.2f)
        insertWeapon("プロモデラーMG", 3.2f, 2.2f, 24f, 19.5f)
        insertWeapon("プロモデラーRG", 3.2f, 2.2f, 24f, 19.5f)
        insertWeapon("わかばシューター", 3.2f, 2.2f, 28f, 22.8f)
        insertWeapon("ヴァリアブルローラー", 5f, 4f, 150f, 30f)
        insertWeapon("カーボンローラー", 3.1f, 2.6f, 100f, 25f)
        insertWeapon("スプラローラー", 3.9f, 3.1f, 150f, 35f)
        insertWeapon("スプラローラーコラボ", 3.9f, 3.1f, 150f, 35f)
        insertWeapon("ダイナモローラー", 5.6f, 4.6f, 150f, 35f)
        insertWeapon("リッター4K", 6.7f, 6.3f, 180f, 40f)
        insertWeapon("4Kスコープ", 7.1f, 6.7f, 180f, 40f)
        insertWeapon("ソイチューバー", 4.7f, 4.3f, 160f, 40f)
        insertWeapon("スプラチャージャー", 5.7f, 5.3f, 160f, 40f)
        insertWeapon("スプラスコープ", 6.1f, 5.7f, 160f, 40f)
        insertWeapon("スプラチャージャーコラボ", 5.7f, 5.3f, 160f, 40f)
        insertWeapon("スプラスコープコラボ", 6.1f, 5.7f, 160f, 40f)
        insertWeapon("14式竹筒銃・甲", 6.0f, 4.3f, 80f, 30f)
        insertWeapon("スクイックリンα", 4.2f, 3.8f, 140f, 40f)
        insertWeapon("ノヴァブラスター", 2.2f, 2.2f, 125f, 50f)
        insertWeapon("ホットブラスターカスタム", 2.7f, 2.7f, 125f, 50f)
        insertWeapon("ホットブラスター", 2.7f, 2.7f, 125f, 50f)
        insertWeapon("クラッシュブラスター", 2.2f, 2.5f, 60f, 30f)
        insertWeapon("ラピッドブラスター", 3.5f, 3.7f, 85f, 35f)
        insertWeapon("ラピッドブラスターエリート", 4.0f, 4.2f, 85f, 35f)
        insertWeapon("バレルスピナー", 5.4f, 4.6f, 28f, 14f)
        insertWeapon("バレルスピナーデコ", 5.4f, 4.6f, 28f, 14f)
        insertWeapon("スプラスピナー", 4f, 2.8f, 28f, 14f)
        insertWeapon("ヒッセン", 2.8f, 2.5f, 62f, 62f)
        insertWeapon("バケットスロッシャー", 3.2f, 3f, 70f, 70f)
        insertWeapon("スクリュースロッシャー", 3.5f, 3.3f, 78f, 38f)
        insertWeapon("ホクサイ", 2.7f, 2.3f, 40f, 25.2f)
        insertWeapon("パブロ", 2.3f, 1.8f, 30f, 18.1f)
    }

    fun insertSkills() {
        insertSkill("マルチミサイル")
        insertSkill("インクアーマー")
        insertSkill("ボムピッチャー")
        insertSkill("ハイパープレッサー")
        insertSkill("ジェットパック")
        insertSkill("スーパーチャクチ")
        insertSkill("アメフラシ")
        insertSkill("イカスフィア")
        insertSkill("バブルランチャー")

        insertSkill("スプラッシュボム")
        insertSkill("ロボットボム")
        insertSkill("キューバンボム")
        insertSkill("カーリングボム")
        insertSkill("クイックボム")
        insertSkill("トラップ")
        insertSkill("スプリンクラー")
        insertSkill("ポイントセンサー")
        insertSkill("ポイズンミスト")
        insertSkill("ジャンプビーコン")

        insertSkill("スプラッシュボム")
        insertSkill("ロボットボム")
        insertSkill("キューバンボム")
        insertSkill("カーリングボム")
        insertSkill("クイックボム")
        insertSkill("トラップ")
        insertSkill("スプリンクラー")
        insertSkill("ポイントセンサー")
        insertSkill("ポイズンミスト")
        insertSkill("ジャンプビーコン")

        insertSkill("インク効率アップ（メイン）")
        insertSkill("インク効率アップ（サブ）")
        insertSkill("インク回復力アップ")
        insertSkill("ヒト移動速度アップ")
        insertSkill("イカダッシュ速度アップ")
        insertSkill("スペシャル増加量アップ")
        insertSkill("スペシャル減少量ダウン")
        insertSkill("スペシャル性能アップ")
        insertSkill("復活時間短縮")
        insertSkill("スーパージャンプ時間短縮")
        insertSkill("サブ性能アップ")
        insertSkill("相手インク影響軽減")
        insertSkill("爆風ダメージ軽減")
        insertSkill("マーキング時間短縮")

        insertSkill("スタートダッシュ")
        insertSkill("ラストスパート")
        insertSkill("逆境強化")
        insertSkill("カムバック")
        insertSkill("イカニンジャ")
        insertSkill("リベンジ")
        insertSkill("サーマルインク")
        insertSkill("復活ペナルティアップ")
        insertSkill("追加ギアパワー倍化")
        insertSkill("ステルスジャンプ")
        insertSkill("対物攻撃力アップ")
        insertSkill("受け身術")

        insertSkill("none")
    }

    fun insertSkill(name: String) {
        realm.executeTransaction {
            val todoModel = it.createObject(SkillMaster::class.java)
            todoModel.name = name
            it.copyToRealm(todoModel)
        }
    }

    fun insertWeapon(name: String, drawRange: Float, hitRange: Float, max: Float, min: Float) {
        realm.executeTransaction {
            val todoModel = it.createObject(WeaponMaster::class.java)
            todoModel.name = name
            todoModel.drawRange = drawRange
            todoModel.hitRange = hitRange
            todoModel.maxDamage = max
            todoModel.minDamage = min
            it.copyToRealm(todoModel)
        }
    }
}