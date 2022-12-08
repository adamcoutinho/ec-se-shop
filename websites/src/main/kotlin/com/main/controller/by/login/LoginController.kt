package com.main.controller.by.login

import com.main.controller.integration.v1.authentication.AuthenticationEndpoint
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

@Controller
class LoginController(@Autowired private val  authenticationEndpoint: AuthenticationEndpoint) {

    companion object {
        const val PAGE_LOGIN_REQUEST = "website-shoponline/authentic/login"
        const val PAGE_LOGIN_RESPONSE = "website-shoponline/authentic/login_response"
    }

    @RequestMapping("/login", method = [RequestMethod.GET])
    fun get(): ModelAndView {
        val mv = ModelAndView(PAGE_LOGIN_REQUEST)
        mv.addObject("formRequest", UserFormRequest())
        return mv
    }

    @RequestMapping("/login", method = [RequestMethod.POST])
    fun post(@ModelAttribute("formRequest") @Validated request: UserFormRequest, bind: BindingResult): ModelAndView {
        println(request.toString())
        var mv = ModelAndView(PAGE_LOGIN_REQUEST)
        if (this.authenticationEndpoint.access(request)) {
            mv = ModelAndView(PAGE_LOGIN_RESPONSE)
        }

        return mv
    }

}