package com.main.entrypoint.rest.by.v1.exception.dto

import org.springframework.validation.FieldError

data class FieldErrorDetailResponse(
    var fieldName:String?=null,
    var message:String?=null
){

    companion object {
        fun builder():FieldErrorDetailResponse {
            return FieldErrorDetailResponse()
        }
    }

    fun fieldName(fieldName: String): FieldErrorDetailResponse {
        this.fieldName=fieldName
        return this
    }

    fun message(message: String): FieldErrorDetailResponse {
        this.message=message
        return this
    }

    fun build():FieldErrorDetailResponse {
        return FieldErrorDetailResponse(
            fieldName=this.fieldName,
            message=this.message
        )
    }
}