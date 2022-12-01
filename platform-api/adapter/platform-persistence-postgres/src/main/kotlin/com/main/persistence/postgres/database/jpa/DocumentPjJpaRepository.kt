package com.main.persistence.postgres.database.jpa

import com.main.persistence.postgres.database.table.schema.ct.DocumentPjEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentPjJpaRepository : JpaRepository<DocumentPjEntity, Long> {
    fun findByIdExternal(idExternal: UUID): DocumentPjEntity?
}