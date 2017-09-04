import java.io.File
import com.squareup.moshi.Moshi

fun main(args : Array<String>) {
    val textFile = File("/Users/sacchin/Documents/data/20170820_a.txt").absoluteFile
    val lines = textFile.readLines().filter(String::isNotBlank)
            .toList()

    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(IksmResponse::class.java)

    lines.forEach {
        val event = jsonAdapter.fromJson(it)
    }
}
