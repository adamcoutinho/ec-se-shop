package com.main.platform.workspace.websites.ecommerce

import com.main.platform.workspace.websites.configservlet.request
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "pageServlet", value = ["/page"])
class PageController : HttpServlet(){

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val request = request(this::class, request,response, "ecommerce/page")

    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        super.doPost(req, resp)
    }
}