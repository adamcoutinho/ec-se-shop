package com.main.platform.adapter.rest.v1.authentication.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

data class AuthenticationFormRequest(
    @JsonProperty("user")
    @field:NotBlank
    val userOrEmail:String?=null,
    @JsonProperty("password")
    @field:NotBlank
    val password:String?=null
)
