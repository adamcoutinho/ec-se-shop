package com.main.entrypoint.rest.by.v1.authentication.validation.annotation

import javax.validation.Constraint
import javax.validation.Payload
import javax.validation.ReportAsSingleViolation

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.reflect.KClass
import org.hibernate.validator.constraints.CompositionType
import org.hibernate.validator.constraints.ConstraintComposition
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

@NotBlank
@Email
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@Constraint(validatedBy = [])
@MustBeDocumented
@Target(FIELD)
@Retention(RUNTIME)
annotation class EmailOrUserName(
    val message: String = "document is not a valid CPF or CNPJ",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
)