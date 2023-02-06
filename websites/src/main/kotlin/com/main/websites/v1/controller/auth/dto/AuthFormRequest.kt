package com.main.websites.v1.controller.auth.dto



data class AuthFormRequest(
    var userName:String?=null,
    val password:String?=null
)