package com.gmail.sacchin.iksmviewer

import io.realm.Realm
import io.realm.RealmResults

class DatabaseHelper(val realm: Realm) {

    fun selectAllBattle(): RealmResults<OneBattle> = realm.where(OneBattle::class.java).findAll()

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
            it.copyToRealm(todoModel1)
            it.copyToRealm(todoModel2)
            it.copyToRealm(todoModel3)
            it.copyToRealm(todoModel4)
            it.copyToRealm(todoModel5)
            it.copyToRealm(todoModel6)
            it.copyToRealm(todoModel7)
            it.copyToRealm(todoModel8)
            it.copyToRealm(todoModel9)
        }
    }

    fun insertWeapons() {
        insertWeapon(1, "パラシェルター", 3.3f, 2.5f, 90f, 12.9f)
        insertWeapon(2, "スパッタリー", 2.9f, 2f, 36f, 18f)
        insertWeapon(3, "スプラマニューバー", 3.5f, 2.5f, 28f, 15.8f)
        insertWeapon(4, "スプラマニューバーコラボ", 3.5f, 2.5f, 28f, 15.8f)
        insertWeapon(5, "デュアルスイーパー", 4.3f, 3.5f, 28f, 20.2f)
        insertWeapon(6, ".52ガロン", 3.5f, 2.5f, 52f, 39f)
        insertWeapon(7, ".96ガロン", 4.5f, 3.4f, 52f, 37.4f)
        insertWeapon(8, "H3リールガン", 4.5f, 3.4f, 41f, 29.5f)
        insertWeapon(9, "L3リールガン", 4.1f, 3.1f, 29f, 21.8f)
        insertWeapon(10, "N-ZAP85", 3.5f, 2.6f, 28f, 21f)
        insertWeapon(11, "ジェットスイーパー", 5.4f, 4.6f, 32f, 21f)
        insertWeapon(12, "シャープマーカー", 3.2f, 2.2f, 28f, 20.2f)
        insertWeapon(13, "ボールドマーカー", 2.8f, 1.6f, 38f, 30.9f)
        insertWeapon(14, "スプラシューター", 3.5f, 2.6f, 35f, 26.3f)
        insertWeapon(15, "スプラシューターコラボ", 3.5f, 2.6f, 35f, 26.3f)
        insertWeapon(16, "プライムシューター", 4.3f, 3.4f, 42f, 30.2f)
        insertWeapon(17, "プライムシューターコラボ", 4.3f, 3.4f, 42f, 30.2f)
        insertWeapon(18, "プロモデラーMG", 3.2f, 2.2f, 24f, 19.5f)
        insertWeapon(19, "プロモデラーRG", 3.2f, 2.2f, 24f, 19.5f)
        insertWeapon(20, "わかばシューター", 3.2f, 2.2f, 28f, 22.8f)
        insertWeapon(21, "ヴァリアブルローラー", 5f, 4f, 150f, 30f)
        insertWeapon(22, "カーボンローラー", 3.1f, 2.6f, 100f, 25f)
        insertWeapon(23, "スプラローラー", 3.9f, 3.1f, 150f, 35f)
        insertWeapon(24, "スプラローラーコラボ", 3.9f, 3.1f, 150f, 35f)
        insertWeapon(25, "ダイナモローラー", 5.6f, 4.6f, 150f, 35f)
        insertWeapon(26, "リッター4K", 6.7f, 6.3f, 180f, 40f)
        insertWeapon(27, "4Kスコープ", 7.1f, 6.7f, 180f, 40f)
        insertWeapon(28, "ソイチューバー", 4.7f, 4.3f, 160f, 40f)
        insertWeapon(29, "スプラチャージャー", 5.7f, 5.3f, 160f, 40f)
        insertWeapon(30, "スプラスコープ", 6.1f, 5.7f, 160f, 40f)
        insertWeapon(31, "スプラチャージャーコラボ", 5.7f, 5.3f, 160f, 40f)
        insertWeapon(32, "スプラスコープコラボ", 6.1f, 5.7f, 160f, 40f)
        insertWeapon(33, "スクイックリンα", 4.2f, 3.8f, 140f, 40f)
        insertWeapon(34, "ノヴァブラスター", 2.2f, 2.2f, 125f, 50f)
        insertWeapon(35, "ホットブラスターカスタム", 2.7f, 2.7f, 125f, 50f)
        insertWeapon(36, "ホットブラスター", 2.7f, 2.7f, 125f, 50f)
        insertWeapon(37, "クラッシュブラスター", 2.2f, 2.5f, 60f, 30f)
        insertWeapon(38, "ラピッドブラスター", 3.5f, 3.7f, 85f, 35f)
        insertWeapon(39, "バレルスピナー", 5.4f, 4.6f, 28f, 14f)
        insertWeapon(40, "スプラスピナー", 4f, 2.8f, 28f, 14f)
        insertWeapon(41, "ヒッセン", 2.8f, 2.5f, 62f, 62f)
        insertWeapon(42, "バケットスロッシャー", 3.2f, 3f, 70f, 70f)
        insertWeapon(43, "スクリュースロッシャー", 3.5f, 3.3f, 78f, 38f)
        insertWeapon(44, "ホクサイ", 2.7f, 2.3f, 40f, 25.2f)
        insertWeapon(45, "パブロ", 2.3f, 1.8f, 30f, 18.1f)
    }

    fun insertWeapon(id: Int, name: String, drawRange: Float, hitRange: Float, max: Float, min: Float) {
        realm.executeTransaction {
            val todoModel = it.createObject(WeaponMaster::class.java, id)
            todoModel.name = name
            todoModel.drawRange = drawRange
            todoModel.hitRange = hitRange
            todoModel.maxDamage = max
            todoModel.minDamage = min
            it.copyToRealm(todoModel)
        }
    }
}