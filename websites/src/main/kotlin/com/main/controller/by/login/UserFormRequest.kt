package com.main.controller.by.login

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

data class UserFormRequest(
    @field:NotBlank
    @SerializedName("user")
    var userName: String? = null,

    @field:NotBlank
    @SerializedName("password")
    var password: String? = null
)