package com.main.entrypoint.rest.by.v1.authentication.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.main.entrypoint.rest.by.v1.authentication.validation.annotation.EmailOrUserName
import javax.validation.constraints.NotBlank

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AuthenticationFormRequest(
    @EmailOrUserName
    val emailOrUserAuthentication: String? = null,
    @field:NotBlank
    val password: String? = null
)