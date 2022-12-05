package com.main.platform.adapter.rest.v1.authentication

import com.main.core.v1.controller.auth.AuthController
import com.main.platform.adapter.rest.v1.authentication.dto.AuthenticationFormRequest
import javax.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class AuthenticationEndpoint(
    private val authController: AuthController
) {

    @PostMapping("/")
    fun post(@RequestBody @Valid request: AuthenticationFormRequest):ResponseEntity<Any> {
        return ResponseEntity.ok( this.authController.execute(request.userOrEmail,request.password))
    }
}