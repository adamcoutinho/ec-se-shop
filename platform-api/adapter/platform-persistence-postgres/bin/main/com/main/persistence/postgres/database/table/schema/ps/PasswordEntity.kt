package com.main.persistence.postgres.database.table.schema.ps

import com.main.persistence.postgres.database.table.pk.PrimaryObjectId
import com.main.persistence.postgres.database.table.schema.ct.AccountEntity
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
@Table(name = "t_passwd", schema = "ps")
@IdClass(PrimaryObjectId::class)
class PasswordEntity(
    @Id
    val idInternal: Long? = null,
    @Id
    val idExternal: UUID? = null,
    @field:Column(name = "created_at")
    val createdAt: LocalDate? = null,
    @field:Column(name = "updated_at")
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
    @field:Column(name = "key_crypt")
    val keyCrypt: String? = null,
    @ManyToOne
    @JoinColumns(
        value = [
            JoinColumn(name = "id_table", referencedColumnName = "id_internal"),
            JoinColumn(name = "id_reference", referencedColumnName = "id_external")
        ]
    )
    val account: AccountEntity? = null
)