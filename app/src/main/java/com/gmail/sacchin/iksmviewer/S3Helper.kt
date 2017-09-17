package com.gmail.sacchin.iksmviewer

import android.os.AsyncTask
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.properties.Delegates

class S3Helper(val activity: MainActivity) : AsyncTask<String, Integer, String>() {
    var s3client by Delegates.notNull<OkHttpClient>()
    val BUCKET_NAME = "https://s3-ap-northeast-1.amazonaws.com/ikapot/"

    init {
        s3client = OkHttpClient()
    }

    fun get(name: String): String {
        val request = Request.Builder()
                .url(BUCKET_NAME + name)
                .build()

        val response = s3client.newCall(request).execute()
        return response.body().string()
    }

    override fun doInBackground(vararg params: String): String {
        val uri = params[0]
        return get(uri)
    }

    override fun onPostExecute(result: String) {
        activity.setResult(result)
    }

}