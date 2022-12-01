package com.main.persistence.postgres.database.table.schema.ps

import com.main.persistence.postgres.database.table.schema.ct.AccountEntity
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
@Table(name = "t_passwd", schema = "ps")
class PasswordEntity(
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
    @field:Column(name = "key_crypt")
    val keyCrypt: String? = null,
    @field:ManyToOne
    @field:JoinColumn(name = "id_t_ac")
    val account: AccountEntity? = null
)