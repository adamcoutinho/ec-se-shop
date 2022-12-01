package com.main.controller.integration.v1.authentication

import com.main.controller.integration.api.ConnectorApi

abstract class AuthenticationEndpointAbstract {

    fun post(url:String,jsonContent:String){
        ConnectorApi()
            .body(jsonContent)
            .post(url)
            .response()
    }
}