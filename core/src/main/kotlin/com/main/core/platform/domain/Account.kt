package com.main.core.platform.domain

import java.util.UUID

data class Account(
    val idInternal: Long? = null,
    val idExternal: UUID? = null,
    val userName: String? = null,
    val email: String? = null,
    val password: String?=null,
    val customer: Customer?=null
)