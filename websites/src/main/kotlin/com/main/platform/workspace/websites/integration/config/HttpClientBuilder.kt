package com.main.platform.workspace.websites.integration.config

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class HttpClientBuilder {
    companion object {


        fun builder() :HttpClientBuilder {
            return HttpClientBuilder()
        }
    }

    fun add(){

    }


    fun syncGet(){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://publicobject.com/helloworld.txt")
            .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            for ((name, value) in response.headers) {
                println("$name: $value")
            }

            println(response.body!!.string())
        }
    }


}