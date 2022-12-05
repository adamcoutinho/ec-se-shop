package com.main.platform.adapter.rest.v1.authentication.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthenticationFormRequest(
    @JsonProperty("user")
    val userOrEmail:String?=null,
    @JsonProperty("password")
    val password:String?=null
)
