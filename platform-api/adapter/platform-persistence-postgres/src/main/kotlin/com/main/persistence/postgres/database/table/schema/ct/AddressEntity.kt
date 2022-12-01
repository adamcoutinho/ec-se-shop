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
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "t_as", schema = "ct")
data class AddressEntity(
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
    @field:Column(name = "state", length = 2)
    val state: String? = null,
    @field:Column(name = "city_name")
    val cityName: String? = null,
    @field:Column(name = "neighborhood")
    val neighborhood: String? = null,
    @field:Column(name = "cep")
    val cep: String? = null,
    @field:Column(name = "number")
    val number: Int? = null,
    @field:Column(name = "address_name")
    val addressName: String? = null,
    @field:Column(name = "complement")
    val complement: String? = null,
    @ManyToOne
    @field:JoinColumn(name = "id_t_ct")
    val customer: CustomerEntity? = null
)