package com.main.core.platform.domain

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

class Password(
    val idInternal: Long? = null,
    val idExternal: UUID? = null,
    val createdAt: LocalDate? = null,
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    val keyCrypt: String? = null,
)