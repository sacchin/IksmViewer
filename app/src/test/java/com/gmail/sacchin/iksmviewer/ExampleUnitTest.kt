package com.gmail.sacchin.iksmviewer

import com.gmail.sacchin.iksmviewer.moshi.IksmResponse
import com.squareup.moshi.Moshi
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {

    @Test
    @Throws(Exception::class)
    fun parse_isCorrect() {


        //var test = """{"unique_id":"11752143231918422219","summary":{"special_count_average":2.72,"count":50,"assist_count_average":1.92,"victory_rate":0.54,"victory_count":27,"kill_count_average":5.86,"defeat_count":23,"death_count_average":3.84}}"""
        var test = """{
        "results":[
        {
            "battle_number":"730",
            "type":"gachi",
            "stage":{
            "image":"/images/stage/bc794e337900afd763f8a88359f83df5679ddf12.png",
            "id":"3",
            "name":"\u30c1\u30e7\u30a6\u30b6\u30e1\u9020\u8239"
        },
            "start_time":1503162005,
            "rule":{
            "key":"tower_control",
            "multiline_name":"\u30ac\u30c1\n\u30e4\u30b0\u30e9",
            "name":"\u30ac\u30c1\u30e4\u30b0\u30e9"
        },
            "weapon_paint_point":19068,
            "player_rank":35,
            "other_team_count":0,
            "udemae":{
            "name":"S",
            "s_plus_number":null,
            "number":9
        },
            "estimate_gachi_power":1730,
            "game_mode":{
            "key":"gachi",
            "name":"\u30ac\u30c1\u30de\u30c3\u30c1"
        },
            "player_result":{
            "player":{
            "udemae":{
            "s_plus_number":null,
            "number":9,
            "name":"S"
        },
            "weapon":{
            "image":"/images/weapon/ad921a57ab1b7721c50873c082bb34591b61021c.png",
            "id":"3010",
            "special":{
            "image_b":"/images/special/415bf85acb0b0dcc478316332fe86efb1fe4f203.png",
            "image_a":"/images/special/abe458a7d13d855f1b27135ccf3e96f46f1f3d10.png",
            "id":"1",
            "name":"\u30a4\u30f3\u30af\u30a2\u30fc\u30de\u30fc"
        },
            "sub":{
            "image_b":"/images/sub/0c90dd7487c0c1179e0e6827b8928143cf04e336.png",
            "name":"\u30af\u30a4\u30c3\u30af\u30dc\u30e0",
            "id":"2",
            "image_a":"/images/sub/5f978ddb4716f0d04fcc737755b0b3d212d5671c.png"
        },
            "name":"\u30d2\u30c3\u30bb\u30f3",
            "thumbnail":"/images/weapon/c1befd17d09a527b66f9d2c8a70849a4969642e4.png"
        },
            "shoes_skills":{
            "main":{
            "image":"/images/skill/04b1de71fba1f14197b9163503955c52fd74858b.png",
            "id":"0",
            "name":"\u30a4\u30f3\u30af\u52b9\u7387\u30a2\u30c3\u30d7(\u30e1\u30a4\u30f3)"
        },
            "subs":[
            {
                "image":"/images/skill/d83b962b84fcea9d02c591c296234f5de77f9682.png",
                "name":"\u30b9\u30da\u30b7\u30e3\u30eb\u6e1b\u5c11\u91cf\u30c0\u30a6\u30f3",
                "id":"6"
            },
            {
                "image":"/images/skill/33087a476135074af856151a89a6fe4d1d3a996e.png",
                "id":"11",
                "name":"\u76f8\u624b\u30a4\u30f3\u30af\u5f71\u97ff\u8efd\u6e1b"
            },
            {
                "image":"/images/skill/33087a476135074af856151a89a6fe4d1d3a996e.png",
                "id":"11",
                "name":"\u76f8\u624b\u30a4\u30f3\u30af\u5f71\u97ff\u8efd\u6e1b"
            }
            ]
        },
            "nickname":"sacchin",
            "clothes_skills":{
            "main":{
            "image":"/images/skill/34e114a50a001778a574f7061039d43e632137b7.png",
            "id":"10",
            "name":"\u30b5\u30d6\u6027\u80fd\u30a2\u30c3\u30d7"
        },
            "subs":[
            null,
            null,
            null
            ]
        },
            "head_skills":{
            "main":{
            "image":"/images/skill/34e114a50a001778a574f7061039d43e632137b7.png",
            "id":"10",
            "name":"\u30b5\u30d6\u6027\u80fd\u30a2\u30c3\u30d7"
        },
            "subs":[
            {
                "name":"\u30b9\u30da\u30b7\u30e3\u30eb\u6027\u80fd\u30a2\u30c3\u30d7",
                "id":"7",
                "image":"/images/skill/f20a3e85feeb6b4bb021d28059afd6265cee0b43.png"
            },
            {
                "image":"/images/skill/34e114a50a001778a574f7061039d43e632137b7.png",
                "id":"10",
                "name":"\u30b5\u30d6\u6027\u80fd\u30a2\u30c3\u30d7"
            },
            {
                "id":"7",
                "name":"\u30b9\u30da\u30b7\u30e3\u30eb\u6027\u80fd\u30a2\u30c3\u30d7",
                "image":"/images/skill/f20a3e85feeb6b4bb021d28059afd6265cee0b43.png"
            }
            ]
        },
            "head":{
            "rarity":1,
            "image":"/images/head/fdf8e33e6de135d14873eaa18169b6897432e411.png",
            "kind":"head",
            "brand":{
            "name":"\u30d5\u30a9\u30fc\u30ea\u30de",
            "frequent_skill":{
            "image":"/images/skill/f20a3e85feeb6b4bb021d28059afd6265cee0b43.png",
            "name":"\u30b9\u30da\u30b7\u30e3\u30eb\u6027\u80fd\u30a2\u30c3\u30d7",
            "id":"7"
        },
            "id":"5",
            "image":"/images/brand/b38b99b3358f587efd1613b72a72c9ca9f81f406.png"
        },
            "id":"3002",
            "thumbnail":"/images/head/78bbff0db6b1e96f555ade5512ff0721ecaaaf76.png",
            "name":"\u30d1\u30a4\u30ed\u30c3\u30c8\u30b4\u30fc\u30b0\u30eb"
        },
            "principal_id":"ee89b46767969ef9",
            "star_rank":0,
            "shoes":{
            "id":"3013",
            "brand":{
            "name":"\u30bf\u30bf\u30ad\u30b1\u30f3\u30b5\u30ad",
            "frequent_skill":{
            "name":"\u30de\u30fc\u30ad\u30f3\u30b0\u6642\u9593\u77ed\u7e2e",
            "id":"13",
            "image":"/images/skill/efa003501e1152ef7b617b9e01517c915e05b7ac.png"
        },
            "id":"17",
            "image":"/images/brand/4b05e494bf9a547b4d625fd52dcdd930a6c4defc.png"
        },
            "name":"\u30a2\u30ed\u30fc\u30ba \u30bf\u30bf\u30ad\u30d9\u30c3\u30c1\u30e5\u30fc",
            "thumbnail":"/images/shoes/8b74ca6b28b317c58cc5b5b5ac8769021195f3e8.png",
            "rarity":2,
            "kind":"shoes",
            "image":"/images/shoes/e63da561defb290846a57d2e4a2f19c5ebb75c82.png"
        },
            "clothes":{
            "id":"5012",
            "brand":{
            "name":"\u30d5\u30a9\u30fc\u30ea\u30de",
            "frequent_skill":{
            "name":"\u30b9\u30da\u30b7\u30e3\u30eb\u6027\u80fd\u30a2\u30c3\u30d7",
            "id":"7",
            "image":"/images/skill/f20a3e85feeb6b4bb021d28059afd6265cee0b43.png"
        },
            "id":"5",
            "image":"/images/brand/b38b99b3358f587efd1613b72a72c9ca9f81f406.png"
        },
            "name":"\u30a4\u30ab\u30bb\u30fc\u30e9\u30fc \u30d6\u30eb\u30fc",
            "thumbnail":"/images/clothes/ecd784ffe389382d46d831e8b00732f4d1e031b7.png",
            "rarity":2,
            "image":"/images/clothes/4423146b1846cd94f5e5d058319f5ad3c7b45a78.png",
            "kind":"clothes"
        },
            "player_rank":35
        },
            "sort_score":-2,
            "kill_count":2,
            "death_count":2,
            "game_paint_point":786,
            "special_count":3,
            "assist_count":5
        },
            "other_team_result":{
            "key":"defeat",
            "name":"LOSE\u2026"
        },
            "elapsed_time":202,
            "my_team_count":100,
            "star_rank":0,
            "my_team_result":{
            "key":"victory",
            "name":"WIN!"
        }
        }]}"""
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(IksmResponse::class.java)


        val dto = adapter.fromJson(test)
        println(dto.results.isEmpty())


        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {


        assertEquals(4, (2 + 2).toLong())
    }
}