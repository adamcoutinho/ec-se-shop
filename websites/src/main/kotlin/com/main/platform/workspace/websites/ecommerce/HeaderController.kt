package com.main.platform.workspace.websites.ecommerce

import com.main.platform.workspace.websites.configservlet.redirect
import com.main.platform.workspace.websites.configservlet.request
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "customerRegisterServlet", value = ["/customer-register"])
class HeaderController: HttpServlet() {

    companion object {

        const val  PAGE_CUSTOMER_REGISTER = "ecommerce/customer_register"
    }
    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val request = request(this::class, request,response, PAGE_CUSTOMER_REGISTER)
    }

}