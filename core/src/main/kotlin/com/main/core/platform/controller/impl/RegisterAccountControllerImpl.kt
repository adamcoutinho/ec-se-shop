package com.main.core.platform.controller.impl

import com.main.core.platform.controller.RegisterAccountController
import com.main.core.platform.controller.exception.UnprocessedException
import com.main.core.platform.domain.Account
import com.main.core.platform.domain.Key
import com.main.core.platform.domain.Password
import com.main.core.platform.port.persistence.RegisterAccountPort
import com.main.core.platform.port.persistence.RegisterKeyPort
import com.main.core.platform.port.persistence.RegisterPasswordPort
import java.util.UUID

class RegisterAccountControllerImpl(
    private val registerAccountPort: RegisterAccountPort,
    private val registerPasswordPort: RegisterPasswordPort,
    private val registerKeyPort: RegisterKeyPort
) : RegisterAccountController {

    override fun execute(account: Account): String {

        val accountRegistered = this.registerAccountPort.save(account)

        val keyRegistered = this.registerKeyPort.save(Key(
            keySecret = UUID.randomUUID().toString()
        ))
        val passwordRegistered = this.registerPasswordPort.save(password = Password(
            keyCrypt = account.password
        ))

        return account.idExternal.toString()
    }

}