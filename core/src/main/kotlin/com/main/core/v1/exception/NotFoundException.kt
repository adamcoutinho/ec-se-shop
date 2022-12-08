package com.main.core.v1.exception

import java.lang.RuntimeException

data class NotFoundException(override val message:String):RuntimeException()