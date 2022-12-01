package com.main.persistence.postgres.adapter

import com.main.core.platform.domain.Customer
import com.main.core.platform.port.persistence.RegisterCustomerPort
import com.main.persistence.postgres.adapter.mapper.toEntity
import com.main.persistence.postgres.database.jpa.CustomerJpaRepository
import javax.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class CustomerJpaRepositoryAdapter(private val customerJpaRepository: CustomerJpaRepository) : RegisterCustomerPort {

    @Transactional
    override fun save(customer: Customer): String {
        val customerRegistered = this.customerJpaRepository.save(customer.toEntity())

        return ""
    }

}