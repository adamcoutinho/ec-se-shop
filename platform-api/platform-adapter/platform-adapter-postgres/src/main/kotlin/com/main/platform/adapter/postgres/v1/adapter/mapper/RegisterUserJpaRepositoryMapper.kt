package com.main.platform.adapter.postgres.v1.adapter.mapper

import com.main.core.v1.domain.RegisterUser
import com.main.platform.adapter.postgres.v1.table.RegisterUserEntity

fun RegisterUser.toRegisterUserEntity() =
    RegisterUserEntity(
        userName = this.userName,
        email = this.email,
        password = this.password
    )

fun RegisterUserEntity.toRegisterUser() =
    RegisterUser(
        userName = this.userName,
        email = this.email,
        password = this.password
    )
