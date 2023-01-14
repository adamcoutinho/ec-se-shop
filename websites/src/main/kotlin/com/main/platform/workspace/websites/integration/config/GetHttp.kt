package com.main.platform.workspace.websites.integration.config

import okhttp3.OkHttpClient
import okhttp3.Request

class GetHttp {

 fun teste() {
     val newClientHttp = OkHttpClient()


     val request = Request.Builder().url("")

         .build()


    val response =  newClientHttp.newCall(request).execute()

     response.body
 }

}