package com.main.entrypoint.rest.by.v1.exception.dto

data class ExceptionDetailResponse(
    var status: Int? = null,
    var statusType: String? = null,
    var message:String?=null
){

    companion object {
        fun builder():ExceptionDetailResponse {
            return ExceptionDetailResponse()
        }
    }

    fun status(status: Int): ExceptionDetailResponse {
        this.status=status
        return this
    }

    fun statusType(statusType: String): ExceptionDetailResponse {
        this.statusType=statusType
        return this
    }

    fun message(message: String): ExceptionDetailResponse {
        this.message=message
        return this
    }

    fun build(): ExceptionDetailResponse {
        return ExceptionDetailResponse(
            status=this.status,
            statusType=this.statusType,
            message=this.message
        )
    }

}