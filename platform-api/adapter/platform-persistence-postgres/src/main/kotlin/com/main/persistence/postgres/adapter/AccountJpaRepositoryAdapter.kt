package com.main.persistence.postgres.adapter

import com.main.core.platform.domain.Account
import com.main.core.platform.port.persistence.RegisterAccountPort
import com.main.persistence.postgres.adapter.mapper.toDomain
import com.main.persistence.postgres.adapter.mapper.toEntity
import com.main.persistence.postgres.database.jpa.AccountJpaRepository
import java.util.regex.Pattern
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

    override fun findByEmailOrUserName(emailOrUserName: String): Account? {

        if (isEmailValid(emailOrUserName)) return this.accountJpaRepository.findByEmail(emailOrUserName)?.toDomain()


        return this.accountJpaRepository.findByUserName(emailOrUserName)?.toDomain()
    }

    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }
}