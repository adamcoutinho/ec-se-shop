package com.main.entrypoint.rest.by.v1.authentication

import com.main.core.platform.controller.RegisterAccountController
import com.main.entrypoint.rest.by.v1.authentication.dto.AuthenticationFormRequest
import com.main.entrypoint.rest.by.v1.authentication.dto.RegisterUserAuthenticationFormRequest
import javax.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authentic")
class AuthenticationEndpoint(private val registerAccountController: RegisterAccountController) {

    @RequestMapping("/")
    fun byAuthentic(@RequestBody @Valid request: AuthenticationFormRequest): ResponseEntity<Any> {
        return ResponseEntity.ok().build()
    }

    @RequestMapping("/", method = [RequestMethod.POST])
    fun post(@RequestBody @Valid request: RegisterUserAuthenticationFormRequest):ResponseEntity<String>{
        return ResponseEntity.ok().body(this.registerAccountController.execute(request.toDomain()))
    }

}