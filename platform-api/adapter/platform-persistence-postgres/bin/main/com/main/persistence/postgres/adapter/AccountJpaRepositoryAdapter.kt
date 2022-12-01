package com.main.persistence.postgres.adapter

import com.main.core.platform.domain.Account
import com.main.core.platform.port.persistence.RegisterAccountPort
import com.main.persistence.postgres.adapter.mapper.toDomain
import com.main.persistence.postgres.adapter.mapper.toEntity
import com.main.persistence.postgres.database.jpa.AccountJpaRepository
import javax.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class AccountJpaRepositoryAdapter(
    private val accountJpaRepository: AccountJpaRepository
) : RegisterAccountPort {

    @Transactional
    override fun save(account: Account): Account {
        return this.accountJpaRepository.save(account.toEntity()).toDomain()
    }

}