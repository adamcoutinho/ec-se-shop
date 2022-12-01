package com.main.persistence.postgres.database.jpa

import com.main.persistence.postgres.database.table.schema.ct.AccountEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface AccountJpaRepository:JpaRepository<AccountEntity,Long> {
    fun findByIdExternal(idExternal:UUID):AccountEntity?
}