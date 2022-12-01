package com.main.persistence.postgres.database.table.schema.ct

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "t_ct", schema = "ct", indexes = arrayOf(Index(columnList = "id_internal,id_external")))
class CustomerEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id_internal")
    val idInternal:Long?=null,
    @field:Column(name = "id_external")
    val idExternal: UUID? = null,
    @field:Column(name = "first_name")
    val firstName: String? = null,
    @field:Column(name = "last_name")
    val lastName: String? = null,
    @field:Column(name = "birth_date")
    val birthDate: LocalDate? = null,
    @field:Column(name = "created_at")
    val createdAt: LocalDate? = null,
    @field:Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @field:OneToOne(mappedBy = "customer")
    val documentPj: DocumentPjEntity? = null,
    @field:OneToOne(mappedBy = "customer")
    val documentPf: DocumentPfEntity? = null,
    @field:OneToOne(mappedBy = "customer")
    val account: AccountEntity?=null,
    @field:OneToMany(mappedBy = "customer")
    val addresses: List<AddressEntity>? = null

)
