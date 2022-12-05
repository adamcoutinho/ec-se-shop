package com.main.platform.adapter.postgres.v1.adapter.mapper

import com.main.core.v1.domain.User
import com.main.platform.adapter.postgres.v1.table.UserEntity

fun UserEntity.toUser() =
    User(
        userName = this.userName,
        password = this.password,
        email = this.email
    )

fun User.toUserEntity() =
    UserEntity(
        userName = this.userName,
        password = this.password,
        email = this.email
    )