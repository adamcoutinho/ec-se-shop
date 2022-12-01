package com.main.entrypoint.rest.by.v1.authentication.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.main.core.platform.domain.Account
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class RegisterUserAuthenticationFormRequest(
    @field:NotBlank
    val userName: String? = null,
    @field:NotBlank
    @field:Email
    val email: String? = null,
    @field:NotBlank
    val password: String? = null
){

    fun toDomain() = Account(
        userName = this.userName,
        email = this.email,
        password = this.password
    )

}