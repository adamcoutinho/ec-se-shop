package com.main.platform.adapter.rest.v1.exception.dto

data class ErrorDetailResponse(
    val status:Int?=null,
    val describe:String?=null,
    val fields:List<FieldDetailResponse>?=null
)