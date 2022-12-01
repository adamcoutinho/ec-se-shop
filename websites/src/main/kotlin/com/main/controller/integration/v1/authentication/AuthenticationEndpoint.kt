package com.main.controller.integration.v1.authentication

import com.main.controller.by.login.UserFormRequest
import org.springframework.stereotype.Service

@Service
class AuthenticationEndpoint: AuthenticationEndpointAbstract() {

    companion object {
        const val url_login="http://localhost:9090/authentic/"
    }

    fun access(request: UserFormRequest) {
        post(url_login, request.toJson())

    }
}