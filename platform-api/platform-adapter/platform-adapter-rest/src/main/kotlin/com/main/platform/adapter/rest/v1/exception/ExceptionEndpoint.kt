package com.main.platform.adapter.rest.v1.exception

import com.main.platform.adapter.rest.v1.exception.dto.ErrorDetailResponse
import com.main.platform.adapter.rest.v1.exception.dto.FieldDetailResponse
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionEndpoint {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExcetpion(methodArgumentNotValidException: MethodArgumentNotValidException): ResponseEntity<Any> {

      val fields =  methodArgumentNotValidException.fieldErrors.map {
            FieldDetailResponse(
                fieldName = it.field,
                message = it.defaultMessage
            )
        }

        return ResponseEntity.status(BAD_REQUEST).body(
            ErrorDetailResponse(
                status = BAD_REQUEST.value(),
                describe = BAD_REQUEST.name,
                fields = fields
            )
        )

    }
}