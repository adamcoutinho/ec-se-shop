package com.main.core.v1.controller.registeruser

import com.main.core.v1.domain.RegisterUser
import com.main.core.v1.exception.NotFoundException
import com.main.core.v1.port.persistence.RegisterUserRepositoryPort

class RegisterUserControllerImpl(private val registerUserRepositoryPort: RegisterUserRepositoryPort) : RegisterUserController {

    override fun execute(registerUser: RegisterUser): RegisterUser {
        return this.registerUserRepositoryPort.save(registerUser)
    }

    override fun execute(userName: String, password: String): RegisterUser? {
        return this.registerUserRepositoryPort.findByUserNameAndPassword(userName, password)
    }

}