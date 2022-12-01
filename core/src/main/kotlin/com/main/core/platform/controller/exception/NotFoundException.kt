package com.main.core.platform.controller.exception

data class NotFoundException(
    val className:Class<Any>?=null,
    override val message:String
): RuntimeException()