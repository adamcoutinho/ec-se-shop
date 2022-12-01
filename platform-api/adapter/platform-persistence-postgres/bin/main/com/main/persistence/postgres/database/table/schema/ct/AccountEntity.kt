package com.main.persistence.postgres.database.table.schema.ct

import com.main.persistence.postgres.database.table.pk.PrimaryObjectId
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
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "t_ac", schema = "ct")
@IdClass(PrimaryObjectId::class)
data class AccountEntity(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id_internal", nullable = true)
    val idInternal: Long? = null,
    @field:Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @field:Column(name = "id_external", insertable = false, updatable = false)
    val idExternal: UUID? = UUID.randomUUID(),
    @field:Column(name = "created_at")
    val createdAt: LocalDate? = LocalDate.now(),
    @field:Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @field:Column(name = "email", unique = true)
    val email: String? = null,
    @field:Column(name = "user_name", unique = true)
    val userName: String? = null,
    @OneToOne
    @JoinColumns(
        value = [
            JoinColumn(name = "id_table", referencedColumnName = "id_internal"),
            JoinColumn(name = "id_reference", referencedColumnName = "id_external")
        ]
    )
    val customer: CustomerEntity? = null,
    @field:OneToOne(mappedBy = "account")
    val key: KeyEntity?=null,
    @field:OneToMany(mappedBy = "account")
    val passwords: List<PasswordEntity>? = null,

):Serializable