package com.main.platform.adapter.postgres.v1.jpa

import com.main.platform.adapter.postgres.v1.table.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository:JpaRepository<UserEntity,Long> {
    fun findByUserNameAndPassword(userName:String, password:String):UserEntity
}