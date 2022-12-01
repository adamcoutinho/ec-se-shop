package com.main.core.platform.controller

import com.main.core.platform.domain.Account

interface RegisterAccountController {
    fun execute(account: Account): String
}