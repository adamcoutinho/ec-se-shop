package com.main.core.platform.controller.impl

import com.main.core.platform.controller.RegisterCustomerController
import com.main.core.platform.domain.Customer
import com.main.core.platform.port.persistence.RegisterCustomerPort

class RegisterCustomerControllerImpl(private val registerCustomerPort: RegisterCustomerPort): RegisterCustomerController {

    override fun execute(customer: Customer): String {
        return this.registerCustomerPort.save(customer)
    }

}