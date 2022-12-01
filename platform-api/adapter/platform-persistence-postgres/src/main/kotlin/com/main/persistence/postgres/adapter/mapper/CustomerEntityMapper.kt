package com.main.persistence.postgres.adapter.mapper

import com.main.core.platform.domain.Customer
import com.main.persistence.postgres.database.table.schema.ct.CustomerEntity

fun Customer.toEntity() = CustomerEntity(
    firstName= this.firstName,
    lastName = this.lastName,
    birthDate = this.birthDate
)
//
fun CustomerEntity.toDomain() = Customer(
    firstName= this.firstName,
    lastName = this.lastName,
    birthDate = this.birthDate
)