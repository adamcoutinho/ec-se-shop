package com.main.entrypoint.rest.by.v1.authentication.validation

import com.main.core.platform.controller.exception.UnprocessedException
import com.main.entrypoint.rest.by.v1.authentication.dto.AuthenticationFormRequest
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class AuthenticationValidator : Validator {

    override fun supports(clazz: Class<*>): Boolean {
        return clazz.isAssignableFrom(AuthenticationFormRequest::class.java)
    }

    override fun validate(target: Any, errorsada: Errors) {

        val request = target as AuthenticationFormRequest

        when {
            request.emailOrUserAuthentication.isNullOrBlank() ||
                    request.emailOrUserAuthentication.isNullOrEmpty() ||
                    EmailValidator.isEmailValid(request.emailOrUserAuthentication) -> {
                throw UnprocessedException(
                             "error"
                )
            };
        }

    }

}