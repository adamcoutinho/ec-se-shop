package com.main.platform.adapter.postgres.v1.adapter

import com.main.core.v1.domain.RegisterUser
import com.main.core.v1.port.persistence.RegisterUserRepositoryPort
import com.main.platform.adapter.postgres.v1.adapter.mapper.toRegisterUser
import com.main.platform.adapter.postgres.v1.adapter.mapper.toRegisterUserEntity
import com.main.platform.adapter.postgres.v1.jpa.RegisterUserJpaRepository

class RegisterUserJpaRepositoryAdapter(private val registerUserJpaRepository: RegisterUserJpaRepository) :
    RegisterUserRepositoryPort {

    override fun save(registerUser: RegisterUser): RegisterUser {
        return this.registerUserJpaRepository.save(registerUser.toRegisterUserEntity()).toRegisterUser()
    }

    override fun findByUserNameAndPassword(userName: String, password: String): RegisterUser {
        return this.registerUserJpaRepository.findByUserNameAndPassword(userName, password)!!.toRegisterUser()
    }

}