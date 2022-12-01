package com.main.persistence.postgres.database.jpa

import com.main.persistence.postgres.database.table.schema.ps.KeyEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface KeyJpaRepository: JpaRepository<KeyEntity,Long> {
    fun findByIdExternal(idExternal:UUID): KeyEntity?
}