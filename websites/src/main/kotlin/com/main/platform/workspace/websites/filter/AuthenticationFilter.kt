package com.main.platform.workspace.websites.filter

import com.main.platform.workspace.websites.configservlet.connectSession
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebFilter(filterName = "authentication-filter", value = ["/*"])
class AuthenticationFilter : HttpFilter(){

    companion object {

        const val USER_SESSION="USER_SESSION"
    }
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
      val user =   connectSession(request as HttpServletRequest,response as HttpServletResponse)
//
         if(!user.sessionIsValid(USER_SESSION)){
//            response.sendRedirect("login")
         }

        chain.doFilter(request,response)
    }
}