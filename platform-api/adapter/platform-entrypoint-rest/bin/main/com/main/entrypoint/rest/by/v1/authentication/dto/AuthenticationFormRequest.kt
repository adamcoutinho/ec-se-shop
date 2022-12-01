package com.main.entrypoint.rest.by.v1.authentication.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AuthenticationFormRequest(
    val emailOrUserAuthentication: String? = null,
    val password: String? = null
)