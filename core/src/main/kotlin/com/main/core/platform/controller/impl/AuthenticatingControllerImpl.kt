package com.main.core.platform.controller.impl

import com.main.core.platform.controller.AuthenticatingController
import com.main.core.platform.port.persistence.RegisterAccountPort
import com.main.core.platform.port.persistence.RegisterKeyPort
import com.main.core.platform.port.persistence.RegisterPasswordPort

class AuthenticatingControllerImpl(
    private val registerAccountPort: RegisterAccountPort,
    private val registerPasswordPort: RegisterPasswordPort,
    private val registerKeyPort: RegisterKeyPort
): AuthenticatingController {

    override fun execute(identifier: String, password: String) {

    }

}