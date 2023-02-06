package com.main.platform.adapter.postgres.v1.jpa

import com.main.platform.adapter.postgres.v1.table.RegisterUserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RegisterUserJpaRepository:JpaRepository<RegisterUserEntity, Long> {
    fun findByUserNameAndPassword(userName:String, password:String):RegisterUserEntity?
}