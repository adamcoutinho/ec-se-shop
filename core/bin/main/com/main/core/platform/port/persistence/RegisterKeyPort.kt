package com.main.core.platform.port.persistence

import com.main.core.platform.domain.Key

interface RegisterKeyPort {
    fun save(key: Key):Key?
}