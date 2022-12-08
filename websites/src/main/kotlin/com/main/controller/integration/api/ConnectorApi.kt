package com.main.controller.integration.api

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

class ConnectorApi(
    private var requestBody: RequestBody? = null,
    private var request: Request? = null,
) {

    companion object {
        fun builder(): ConnectorApi = ConnectorApi()
    }

    fun body(jsonContent: String): ConnectorApi {
        this.requestBody = jsonContent.toRequestBody(APPLICATION_JSON_VALUE.toMediaTypeOrNull())
        return this
    }

    fun post(url:String): ConnectorApi {
        this.request = Request.Builder()
            .url(url)
            .post(this.requestBody!!).build()
        return this
    }

    fun get(url:String): ConnectorApi {
        this.request = Request.Builder()
            .url(url)
            .get()
            .build()
        return this
    }

    fun response() =
        OkHttpClient()
            .newBuilder()
            .build()
            .newCall(request!!).execute()
}