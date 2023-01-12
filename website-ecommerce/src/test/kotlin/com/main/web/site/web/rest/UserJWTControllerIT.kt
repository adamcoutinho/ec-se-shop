package com.main.web.site.web.rest

import com.main.web.site.IntegrationTest
import com.main.web.site.web.rest.vm.LoginVM
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.hamcrest.Matchers.*

/**
 * Integration tests for the [UserJWTController] REST controller.
 */
@AutoConfigureMockMvc
@IntegrationTest
class UserJWTControllerIT {


    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun testAuthorize() {
        val login = LoginVM(username ="test", password = "test")
        mockMvc.perform(
            post("/api/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(login))
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.id_token").isString)
            .andExpect(jsonPath("\$.id_token").isNotEmpty)
            .andExpect(header().string("Authorization", not(nullValue())))
            .andExpect(header().string("Authorization", not(`is`(emptyString()))))
    }

    @Test
    @Throws(Exception::class)
    fun testAuthorizeWithRememberMe() {
        val login = LoginVM(
            username ="test",
            password = "test",
            isRememberMe = true
        )
        mockMvc.perform(
            post("/api/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(login))
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.id_token").isString)
            .andExpect(jsonPath("\$.id_token").isNotEmpty)
            .andExpect(header().string("Authorization", not(nullValue())))
            .andExpect(header().string("Authorization", not(`is`(emptyString()))))
    }

    @Test
    @Throws(Exception::class)
    fun testAuthorizeFails() {
        val login = LoginVM(username = "wrong-user", password = "wrong password")
        mockMvc.perform(
            post("/api/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(login))
        )
            .andExpect(status().isUnauthorized)
            .andExpect(jsonPath("\$.id_token").doesNotExist())
            .andExpect(header().doesNotExist("Authorization"))
    }
}
