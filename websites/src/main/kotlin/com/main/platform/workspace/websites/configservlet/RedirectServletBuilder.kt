package com.main.platform.workspace.websites.configservlet

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class RedirectServletBuilder(private val request: HttpServletRequest,private val response: HttpServletResponse) {

    companion object {

        fun builder(request: HttpServletRequest, response: HttpServletResponse): RedirectServletBuilder {
            return RedirectServletBuilder(request, response)
        }

    }

    fun servletName(pathRedirect: String) {
//        this.response.sendRedirect("WEB-INF/sites/$pathRedirect.jsp")
        response.sendRedirect(pathRedirect)
    }
}