package com.main.controller.integration.v1.authentication

import com.google.gson.Gson
import com.main.controller.by.login.UserDetailResponse
import com.main.controller.by.login.UserFormRequest
import org.springframework.stereotype.Service

@Service
class AuthenticationEndpoint: AuthenticationEndpointAbstract() {

    companion object {
        const val url_login="http://localhost:9090/v1/user/"
    }

    fun access(request: UserFormRequest):Boolean {
       val responseBody = post(url_login, Gson().toJson(request))


   val user =     Gson().fromJson(responseBody.body.string(),UserDetailResponse::class.java)
        println(user.toString())
        return true
    }
}