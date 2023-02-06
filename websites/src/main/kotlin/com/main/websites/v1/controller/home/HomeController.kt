package com.main.websites.v1.controller.home

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/page")
class HomeController {

    @GetMapping
    fun get(): ModelAndView {
        return ModelAndView("home/home")
    }

}