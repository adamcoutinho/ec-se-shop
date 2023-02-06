package com.main.core.v1.domain.enumtype

enum class UserStatusEnum(val status: Int, val describe: String) {
    ACTIVE(1, "ACTIVE"),
    INACTIVE(2, "DESACTIVE"),
    DELETE(3, "DELETED")
}