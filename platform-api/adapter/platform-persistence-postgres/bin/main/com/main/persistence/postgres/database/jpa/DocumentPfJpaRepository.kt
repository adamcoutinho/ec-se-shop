package com.main.persistence.postgres.database.jpa

import com.main.persistence.postgres.database.table.schema.ct.DocumentPfEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface DocumentPfJpaRepository : JpaRepository<DocumentPfEntity, Long> {
    fun findByIdExternal(idExternal: UUID): DocumentPfEntity?
}