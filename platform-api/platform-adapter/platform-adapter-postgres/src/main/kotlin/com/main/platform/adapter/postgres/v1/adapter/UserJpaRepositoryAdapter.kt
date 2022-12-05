package com.main.platform.adapter.postgres.v1.adapter

import com.main.core.v1.domain.User
import com.main.core.v1.port.persistence.UserRepositoryPort
import com.main.platform.adapter.postgres.v1.adapter.mapper.toUser
import com.main.platform.adapter.postgres.v1.adapter.mapper.toUserEntity
import com.main.platform.adapter.postgres.v1.jpa.UserJpaRepository

class UserJpaRepositoryAdapter(private val userJpaRepository: UserJpaRepository) : UserRepositoryPort {

    override fun save(user: User): User {
        return this.userJpaRepository.save(user.toUserEntity()).toUser()
    }

    override fun find(userName: String, password: String): User {
        return this.userJpaRepository.findByUserNameAndPassword(userName,password).toUser()
    }
}