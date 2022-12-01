package com.main.persistence.postgres.adapter.mapper

import com.main.core.platform.domain.Key
import com.main.persistence.postgres.database.table.schema.ps.KeyEntity


fun Key.toEntity() =
    KeyEntity(
        idInternal = this.idInternal,
        idExternal = this.idExternal,
        keySecret = this.keySecret
    )


fun KeyEntity.toDomain() =
    Key(
        idInternal = this.idInternal,
        idExternal = this.idExternal,
        keySecret = this.keySecret
    )