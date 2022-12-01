package com.main.core.platform.controller

import com.main.core.platform.domain.Customer

interface RegisterCustomerController {
    fun execute(customer: Customer,emailOrUserName:String):String
}