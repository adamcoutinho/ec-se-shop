package com.main.persistence.postgres.database.table.schema.ct

import com.main.persistence.postgres.database.table.pk.PrimaryObjectId
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "t_as", schema = "ct")
@IdClass(PrimaryObjectId::class)
class AddressEntity(
    @Id
    val idInternal: Long? = null,
    @Id
    val idExternal: UUID? = null,
    @field:Column(name = "created_at")
    val createdAt: LocalDate? = null,
    @field:Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @field:Column(name = "state", length = 2)
    val state: String? = null,
    @field:Column(name = "city_name")
    val cityName: String? = null,
    @field:Column(name = "neighborhood")
    val neighborhood: String? = null,
    @field:Column(name = "cep")
    val cep: String? = null,
    @field:Column(name = "number")
    val number: Int?=null,
    @field:Column(name = "address_name")
    val addressName: String? = null,
    @field:Column(name = "complement")
    val complement: String? = null,
    @ManyToOne
    @JoinColumns(
        value = [
            JoinColumn(name = "id_table", referencedColumnName = "id_internal"),
            JoinColumn(name = "id_reference", referencedColumnName = "id_external")
        ]
    )
    val customer: CustomerEntity? = null

)