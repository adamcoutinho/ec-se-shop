package com.main.platform.adapter.rest.v1.authentication.dto

import com.main.core.v1.domain.RegisterUser
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class RegisterAuthenticationFormRequest(
    @NotBlank
    val user: String? = null,
    @Email
    val email: String? = null,
    @NotBlank
    val password: String? = null
) {
    fun toRegisterUser() =
        RegisterUser(
            userName = this.user,
            email = email,
            password = password
        )
}
