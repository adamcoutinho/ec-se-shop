package com.main.core.v1.controller.auth

import com.main.core.v1.domain.User

interface AuthController {
    fun execute(userName:String?=null,password:String?=null): User
}