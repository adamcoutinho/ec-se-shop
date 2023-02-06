package com.main.core.v1.controller.registeruser

import com.main.core.v1.domain.RegisterUser

interface RegisterUserController {

    fun execute(registerUser:RegisterUser):RegisterUser

    fun execute(userName:String, password:String):RegisterUser?
}