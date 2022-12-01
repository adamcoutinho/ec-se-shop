package com.main.entrypoint.rest.by.v1.exception.dto

data class ErrorDetailResponse(
    var status: Int? = null,
    var statusType: String? = null,
    var fields: List<FieldErrorDetailResponse>? = null
) {

    companion object {
        fun builder(): ErrorDetailResponse {
            return ErrorDetailResponse()
        }
    }

    fun status(status: Int?): ErrorDetailResponse {
        this.status = status
        return this
    }

    fun statusType(statusType: String): ErrorDetailResponse {
        this.statusType = statusType
        return this
    }

    fun fields(fields: List<FieldErrorDetailResponse>): ErrorDetailResponse {
        this.fields = fields
        return this
    }

    fun build(): ErrorDetailResponse {
        return ErrorDetailResponse(
            status = this.status,
            statusType = this.statusType,
            fields = this.fields
        )
    }

}