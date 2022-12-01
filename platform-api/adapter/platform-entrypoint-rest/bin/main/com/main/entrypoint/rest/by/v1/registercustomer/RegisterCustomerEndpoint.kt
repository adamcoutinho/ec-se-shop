package com.main.entrypoint.rest.by.v1.registercustomer

import com.main.core.platform.controller.RegisterCustomerController
import com.main.entrypoint.rest.by.v1.registercustomer.dto.RegisterCustomerFormRequest
import java.util.UUID
import javax.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class RegisterCustomerEndpoint(private val registerCustomerController: RegisterCustomerController) {

    @RequestMapping(value = ["/{id_external}"], method = [RequestMethod.GET])
    fun get(@PathVariable("id_external") idExternal: UUID, @RequestHeader("flux-id") fluxId:UUID):List<UUID> {
        val array = listOf<UUID>(idExternal,fluxId)
        return array
    }

    @RequestMapping(value = ["/"], method = [RequestMethod.POST])
    fun register(@RequestBody @Valid request: RegisterCustomerFormRequest): ResponseEntity<Any> {
        return ResponseEntity.ok(this.registerCustomerController.execute(request.toDomain()))
    }

}