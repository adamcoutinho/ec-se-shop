package com.main.controller.by.home

import com.main.controller.by.login.LoginController
import com.main.controller.by.login.UserFormRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class HomeController {
    @RequestMapping("/")
//    fun get(): ModelAndView {
//        val mv = ModelAndView("website-shoponline/index")
//        return mv
//    }
    fun get(): ModelAndView {
        val mv = ModelAndView(LoginController.PAGE_LOGIN_REQUEST)
        mv.addObject("formRequest", UserFormRequest())
        return mv
    }
}