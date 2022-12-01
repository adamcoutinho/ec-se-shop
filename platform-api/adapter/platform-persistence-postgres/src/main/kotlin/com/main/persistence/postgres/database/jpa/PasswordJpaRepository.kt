package com.main.persistence.postgres.database.jpa

import com.main.persistence.postgres.database.table.schema.ps.PasswordEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface PasswordJpaRepository : JpaRepository<PasswordEntity, Long> {
    fun findByIdExternal(idExternal: UUID): PasswordEntity?
}