package com.main.core.platform.port.persistence

import com.main.core.platform.domain.Customer

interface RegisterCustomerPort {
    fun save(customer:Customer): String
}