package com.main.persistence.postgres.adapter.mapper

import com.main.core.platform.domain.Password
import com.main.persistence.postgres.database.table.schema.ps.PasswordEntity

fun Password.toEntity() =
    PasswordEntity(
        idInternal = this.idInternal,
        idExternal = this.idExternal,
        keyCrypt = this.keyCrypt
    )
fun PasswordEntity.toDomain() =
    Password(
        idInternal = this.idInternal,
        idExternal = this.idExternal,
        keyCrypt = this.keyCrypt
    )