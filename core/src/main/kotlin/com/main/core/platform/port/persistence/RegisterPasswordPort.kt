package com.main.core.platform.port.persistence

import com.main.core.platform.domain.Password

interface RegisterPasswordPort {
    fun save (password:Password):Password?
}