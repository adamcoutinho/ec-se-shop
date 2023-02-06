package com.main.platform.adapter.rest.v1.authentication

import com.main.core.v1.controller.auth.AuthController
import com.main.core.v1.controller.registeruser.RegisterUserController
import com.main.platform.adapter.rest.v1.authentication.dto.AuthenticationFormRequest
import com.main.platform.adapter.rest.v1.authentication.dto.RegisterAuthenticationFormRequest
import com.main.platform.adapter.rest.v1.authentication.dto.mapper.toUserDetailResponse
import javax.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/user")
class AuthenticationEndpoint(
    private val authController: AuthController,
    private val registerUserController: RegisterUserController
) {

    @PostMapping("/")
    fun post(@RequestBody @Valid request: AuthenticationFormRequest):ResponseEntity<Any> {
        return ResponseEntity.ok( this.registerUserController.execute(request.userOrEmail!!,request.password!!)!!.toUserDetailResponse())
    }

    @PostMapping("/new")
    fun post(@RequestBody @Valid request: RegisterAuthenticationFormRequest):ResponseEntity<Any> {
        return ResponseEntity.ok( this.registerUserController.execute(request.toRegisterUser()).toUserDetailResponse())
    }
}