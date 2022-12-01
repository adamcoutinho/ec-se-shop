package com.main.core.platform.port.persistence

import com.main.core.platform.domain.Account

interface RegisterAccountPort {
    fun save(account: Account):Account
    fun findByEmailOrUserName(emailOrUserName:String):Account?
}