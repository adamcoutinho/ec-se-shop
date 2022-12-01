package com.main.controller.by.login

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import org.hibernate.validator.constraints.Email
import org.hibernate.validator.constraints.NotBlank

data class UserFormRequest(
    @field:NotBlank
    @SerializedName("user_name")
    var userName: String? = null,
    @field:NotBlank
    @field:Email
    var email: String? = "teste@live.com",
    @field:NotBlank
    var password: String? = null
) {
    fun toJson() = Gson().toJson(this)
}