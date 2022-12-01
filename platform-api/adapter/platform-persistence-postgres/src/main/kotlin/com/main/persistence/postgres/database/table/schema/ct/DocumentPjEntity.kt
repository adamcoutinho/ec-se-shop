package com.main.persistence.postgres.database.table.schema.ct

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "t_dc_cnpj_lgpd", schema = "ct")
data class DocumentPjEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id_internal")
    val idInternal:Long?=null,
    @field:Column(name = "id_external")
    val idExternal: UUID? = null,
    @field:Column(name = "created_at")
    val createdAt: LocalDate? = null,
    @field:Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @field:Column(name="document")
    val document:String?=null,
    @field:OneToOne
    @field:JoinColumn(name = "id_t_ct")
    val customer: CustomerEntity? = null
)