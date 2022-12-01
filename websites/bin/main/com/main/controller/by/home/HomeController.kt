package com.main.controller.by.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class HomeController {
    @RequestMapping("/")
    fun get(): ModelAndView {
        val mv = ModelAndView("index")
        return mv
    }
}