package com.main.platform.adapter.rest.v1.authentication.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserDetailResponse(
    @JsonProperty("user_name")
    val userName:String?=null,
    @JsonProperty("email")
    val email:String?=null
)