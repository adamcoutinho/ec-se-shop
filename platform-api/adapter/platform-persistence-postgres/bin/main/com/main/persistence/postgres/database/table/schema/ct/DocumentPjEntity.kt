package com.main.persistence.postgres.database.table.schema.ct

import com.main.persistence.postgres.database.table.pk.PrimaryObjectId
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "t_dc_cnpj_lgpd", schema = "ct")
@IdClass(PrimaryObjectId::class)
class DocumentPjEntity(
    @Id
    val idInternal: Long? = null,
    @Id
    val idExternal: UUID? = null,
    @field:Column(name = "created_at")
    val createdAt: LocalDate? = null,
    @field:Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @field:Column(name="document")
    val document:String?=null,
    @field:OneToOne
    @field:JoinColumns(value =[
        JoinColumn(name = "id_table", referencedColumnName = "id_internal"),
        JoinColumn(name = "id_reference", referencedColumnName = "id_external")
    ] )
    val customer: CustomerEntity?=null
)