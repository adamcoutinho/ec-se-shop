package com.main.core.v1.port.persistence

import com.main.core.v1.domain.User

interface UserRepositoryPort {
    fun save(user:User):User
    fun find(userName:String, password:String):User
}