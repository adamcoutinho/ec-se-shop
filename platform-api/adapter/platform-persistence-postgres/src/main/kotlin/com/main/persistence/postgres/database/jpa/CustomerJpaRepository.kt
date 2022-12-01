package com.main.persistence.postgres.database.jpa

import com.main.persistence.postgres.database.table.schema.ct.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerJpaRepository: JpaRepository<CustomerEntity,Long>