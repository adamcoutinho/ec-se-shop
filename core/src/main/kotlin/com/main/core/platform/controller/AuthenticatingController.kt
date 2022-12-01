package com.main.core.platform.controller

interface AuthenticatingController {
    fun execute(identifier:String,password:String)
}