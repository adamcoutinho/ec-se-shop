package com.main.core.v1.port.persistence

import com.main.core.v1.domain.RegisterUser

interface RegisterUserRepositoryPort {

    fun save(registerUser:RegisterUser):RegisterUser

    fun findByUserNameAndPassword(userName:String, password:String):RegisterUser?
}