package com.main.entrypoint.rest.by.v1.registercustomer.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.main.core.platform.domain.Customer
import java.time.LocalDate
import java.util.UUID
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class RegisterCustomerFormRequest(
    @field:NotBlank
    val identifierUser: String? = null,
    @field:NotNull
    val customer: CustomerFormRequest?=null
) {

    fun getIdentificationObject() = this.identifierUser

    fun getCustomerDomain() = this.customer
}

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class CustomerFormRequest(
    @field:NotBlank
    val firstName: String? = null,
    @field:NotBlank
    val lastName: String? = null,
    @field:NotNull
    val birthDate: LocalDate? = null
) {

    fun toDomain() = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        birthDate = this.birthDate
    )

}