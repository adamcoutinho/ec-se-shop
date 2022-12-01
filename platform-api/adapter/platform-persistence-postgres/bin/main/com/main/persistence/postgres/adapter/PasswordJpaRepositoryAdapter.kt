package com.main.persistence.postgres.adapter

import com.main.core.platform.domain.Password
import com.main.core.platform.port.persistence.RegisterPasswordPort
import com.main.persistence.postgres.adapter.mapper.toDomain
import com.main.persistence.postgres.adapter.mapper.toEntity
import com.main.persistence.postgres.database.jpa.PasswordJpaRepository
import javax.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PasswordJpaRepositoryAdapter(private val passwordJpaRepository: PasswordJpaRepository): RegisterPasswordPort {

    @Transactional
    override fun save(password: Password): Password? {
        return this.passwordJpaRepository.save(password.toEntity()).toDomain()
    }

}