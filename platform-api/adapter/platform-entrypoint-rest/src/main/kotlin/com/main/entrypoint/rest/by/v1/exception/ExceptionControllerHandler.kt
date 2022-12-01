package com.main.entrypoint.rest.by.v1.exception

import com.main.core.platform.controller.exception.NotFoundException
import com.main.core.platform.controller.exception.UnprocessedException
import com.main.entrypoint.rest.by.v1.exception.dto.ExceptionDetailResponse
import io.klogging.classNameOf
import java.lang.RuntimeException
import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionControllerHandler {

    @ExceptionHandler(value=[
        UnprocessedException::class,
        NotFoundException::class
    ])
    fun unProcessed(runtimeException: RuntimeException): ResponseEntity<ExceptionDetailResponse> {

        val exceptionDetailResponse = ExceptionDetailResponse.builder()
            .status(UNPROCESSABLE_ENTITY.value())
            .statusType(UNPROCESSABLE_ENTITY.name)
            .message(runtimeException.message!!)
//            .className(runtimeException.cause!!.message!!)
            .build()

        return ResponseEntity.status(UNPROCESSABLE_ENTITY).body(exceptionDetailResponse)
    }

}