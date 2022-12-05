package com.main.core.v1.domain

import com.main.core.v1.domain.enumtype.UserStatusEnum

data class User(
    val userName: String? = null,
    val password: String? = null,
    val email:String?=null,
    val status: UserStatusEnum? = null
)