package com.main.controller.by.login

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("user_name")
    val user:String?=null
)