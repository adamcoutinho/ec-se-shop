package com.main.websites.v1.controller.auth

import com.main.websites.v1.controller.auth.dto.AuthFormRequest
import org.springframework.http.MediaType.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/auth")
class AuthController {

    @GetMapping
    fun get():ModelAndView {
        return ModelAndView("auth/authentic")
    }

    @PostMapping
    fun post(@RequestBody formRequest:AuthFormRequest): ResponseEntity<AuthFormRequest> {
        println("${formRequest.userName} - ${formRequest.password}")


        return ResponseEntity.ok(formRequest)
    }

}