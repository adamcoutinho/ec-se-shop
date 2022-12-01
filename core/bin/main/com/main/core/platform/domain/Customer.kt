package com.main.core.platform.domain

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Customer(
    val idInternal: Long? = null,
    val idExternal: UUID? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val birthDate: LocalDate? = null,
    val createdAt: LocalDate? = null,
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    val documentPf: DocumentPf? = null,
    val documentPj: DocumentPj? = null,
    val key: Key?=null,
    val account: Account?=null,
    val passwords: List<Password>? = null,
    val addresses: List<Address>? = null
)