package com.main.platform.workspace.websites.ecommerce.authentic.dto

import com.google.gson.annotations.SerializedName


data class LoginFormRequest(
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("user_password")
    val userPassword: String)