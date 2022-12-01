package com.main.entrypoint.rest.by.v1.exception

import com.main.entrypoint.rest.by.v1.exception.dto.ErrorDetailResponse
import com.main.entrypoint.rest.by.v1.exception.dto.FieldErrorDetailResponse
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerEndpoint {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidExceptiom(methodArgumentNotValidException: MethodArgumentNotValidException): ResponseEntity<ErrorDetailResponse> {

        val fields = methodArgumentNotValidException.fieldErrors.map {
            FieldErrorDetailResponse.builder()
            .fieldName(it.field)
            .message(it.defaultMessage)
            .build()
        }

        val errorDetailResponse = ErrorDetailResponse.builder()
            .status(BAD_REQUEST.value())
            .statusType(BAD_REQUEST.name)
            .fields(fields)
            .build()

        return ResponseEntity.status(BAD_REQUEST).body(errorDetailResponse)
    }

}