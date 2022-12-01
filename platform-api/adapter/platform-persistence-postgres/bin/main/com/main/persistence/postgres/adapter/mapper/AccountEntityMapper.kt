package com.main.persistence.postgres.adapter.mapper

import com.main.core.platform.domain.Account
import com.main.persistence.postgres.database.table.schema.ct.AccountEntity
import java.util.UUID

fun Account.toEntity() =
    AccountEntity(
        userName = this.userName,
        email = this.email
    )

fun AccountEntity.toDomain() =
    Account(
        email = this.email,
        userName = this.userName
    )