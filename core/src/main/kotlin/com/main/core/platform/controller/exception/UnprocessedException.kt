package com.main.core.platform.controller.exception


data class UnprocessedException(
    override val message:String
): RuntimeException()
