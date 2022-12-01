package com.main.controller.by.login

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class LoginController {
    @RequestMapping("/login")
    fun get():ModelAndView {
        val mv = ModelAndView("page_user")
        return mv
    }
}