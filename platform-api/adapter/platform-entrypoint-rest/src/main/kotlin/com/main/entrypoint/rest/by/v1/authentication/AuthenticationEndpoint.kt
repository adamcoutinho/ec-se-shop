package com.main.entrypoint.rest.by.v1.authentication

import com.main.core.platform.controller.AuthenticatingController
import com.main.core.platform.controller.RegisterAccountController
import com.main.entrypoint.rest.by.v1.authentication.dto.AuthenticationFormRequest
import com.main.entrypoint.rest.by.v1.authentication.dto.RegisterUserAuthenticationFormRequest
import com.main.entrypoint.rest.by.v1.authentication.validation.AuthenticationValidator
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/authentic")
class AuthenticationEndpoint(
    private val authenticationValidator: AuthenticationValidator ,
    private val registerAccountController: RegisterAccountController,
    private val authenaticatingController: AuthenticatingController) {

    @InitBinder
    fun webdataBainder(webDataBinder:WebDataBinder){
        webDataBinder.addValidators(authenticationValidator)
    }

    @RequestMapping("/", method = [POST])
    fun authenticationPost(@RequestBody @Valid request: AuthenticationFormRequest):ResponseEntity<String>{
        this.authenaticatingController.execute(request.emailOrUserAuthentication!!,request.password!!)
        return ResponseEntity.ok().build()
    }

    @RequestMapping("/new", method = [POST])
    fun registerUserAuthenticationPost(@RequestBody @Valid request: RegisterUserAuthenticationFormRequest):ResponseEntity<String>{
        return ResponseEntity.ok().body(this.registerAccountController.execute(request.toDomain()))
    }

}