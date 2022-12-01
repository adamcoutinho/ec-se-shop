package com.main.persistence.postgres.adapter

import com.main.core.platform.domain.Key
import com.main.core.platform.port.persistence.RegisterKeyPort
import com.main.persistence.postgres.adapter.mapper.toDomain
import com.main.persistence.postgres.adapter.mapper.toEntity
import com.main.persistence.postgres.database.jpa.KeyJpaRepository
import javax.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class KeyJpaRepositoryAdapter(private val registerKeyJpaRepository: KeyJpaRepository): RegisterKeyPort {

    @Transactional
    override fun save(key: Key): Key? {
        return this.registerKeyJpaRepository.save(key.toEntity()).toDomain()
    }

}