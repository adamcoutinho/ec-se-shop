package com.main.persistence.postgres.database.jpa

import com.main.persistence.postgres.database.table.schema.ct.AddressEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface AddressJpaRepository : JpaRepository<AddressEntity, Long> {
    fun findByIdExternal(idExternal: UUID): AddressEntity?
}