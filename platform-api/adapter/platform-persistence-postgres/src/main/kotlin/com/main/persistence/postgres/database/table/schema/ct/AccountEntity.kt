package com.main.persistence.postgres.database.table.schema.ct

import com.main.persistence.postgres.database.table.schema.ps.KeyEntity
import com.main.persistence.postgres.database.table.schema.ps.PasswordEntity
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "t_ac", schema = "ct")
data class AccountEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id_internal")
    val idInternal:Long?=null,
    @field:Column(name = "id_external")
    val idExternal: UUID? = null,
    @field:Column(name = "created_at")
    val createdAt: LocalDate? = LocalDate.now(),
    @field:Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @field:Column(name = "email", unique = true)
    val email: String? = null,
    @field:Column(name = "user_name", unique = true)
    val userName: String? = null,
    @field:OneToOne
    @field:JoinColumn(name = "id_t_ct")
    val customer: CustomerEntity?=null,
    @field:OneToOne(mappedBy = "account")
    val key: KeyEntity?=null,
    @field:OneToMany(mappedBy = "account")
    val passwords: List<PasswordEntity>? = null,

):Serializable