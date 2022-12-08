package com.main.platform.adapter.rest.v1.authentication.dto.mapper

import com.main.core.v1.domain.RegisterUser
import com.main.platform.adapter.rest.v1.authentication.dto.UserDetailResponse

fun RegisterUser.toUserDetailResponse() =
    UserDetailResponse(
        userName = this.userName,
        email = this.email
    )