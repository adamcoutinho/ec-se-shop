package com.main.core.platform.controller.impl

import com.main.core.platform.controller.RegisterCustomerController
import com.main.core.platform.controller.exception.NotFoundException
import com.main.core.platform.controller.exception.UnprocessedException
import com.main.core.platform.domain.Customer
import com.main.core.platform.port.persistence.RegisterAccountPort
import com.main.core.platform.port.persistence.RegisterCustomerPort

class RegisterCustomerControllerImpl(
    private val registerCustomerPort: RegisterCustomerPort,
    private val registerAccountPort: RegisterAccountPort
) : RegisterCustomerController {

    override fun execute(customer: Customer, emailOrUserName: String): String {
        val account = this.registerAccountPort.findByEmailOrUserName(emailOrUserName);

        account.let {
            throw NotFoundException(this.javaClass,"user not found")
        }



        val customerRegistered = this.registerCustomerPort.save(customer)

        account?.customer = customerRegistered

        this.registerAccountPort.save(account!!)

        return customerRegistered.idExternal.toString()
    }

}