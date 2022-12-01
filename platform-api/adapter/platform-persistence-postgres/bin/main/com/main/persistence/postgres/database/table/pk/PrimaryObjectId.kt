package com.main.persistence.postgres.database.table.pk

import java.io.Serializable
import java.util.UUID
import javax.persistence.Column

data class PrimaryObjectId(
    @field:Column(name = "id_internal")
    var idInternal: Long? = null,
    @field:Column(name = "id_external")
    val idExternal: UUID? = UUID.randomUUID()
): Serializable