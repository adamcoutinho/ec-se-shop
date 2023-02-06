package com.main.core.v1.port.persistence

import com.main.core.v1.domain.Customer

interface CustomerRepositoryPort {
    fun save(customer: Customer)
}