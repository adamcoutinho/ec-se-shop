package com.main.core.platform.controller.exception

data class NotFoundException(
    override val message:String
): RuntimeException()