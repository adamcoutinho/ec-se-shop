package com.main.core.v1.controller.auth

import com.main.core.v1.domain.User
import com.main.core.v1.port.persistence.UserRepositoryPort

class AuthControllerImpl(private val userRepositoryPort: UserRepositoryPort) : AuthController {

    override fun execute(userName: String?, password: String?): User {
       return this.userRepositoryPort.find(userName!!, password!!)
    }
}