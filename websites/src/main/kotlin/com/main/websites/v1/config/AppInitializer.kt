package com.main.websites.v1.config

import org.springframework.web.context.request.RequestContextListener
import org.springframework.web.filter.CharacterEncodingFilter
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer
import javax.servlet.Filter
import javax.servlet.ServletContext
import javax.servlet.ServletException


class AppInitializer : AbstractAnnotationConfigDispatcherServletInitializer() {

    override fun getRootConfigClasses(): Array<Class<*>> {
        return arrayOf(AppContext::class.java)
    }

    override fun getServletConfigClasses(): Array<Class<*>> {
        return arrayOf(
            WebMvcConfig::class.java
        )
    }

    override fun getServletMappings(): Array<String> {
        println("loader servlets")
        return arrayOf("/")
    }
    override fun getServletFilters(): Array<Filter> {
        val encodingFilter = CharacterEncodingFilter()
        encodingFilter.encoding = "UTF-8"
        return arrayOf(encodingFilter)
    }

    @Throws(ServletException::class)
    override fun onStartup(servletContext: ServletContext) {
        println("load spring profiles")
        super.onStartup(servletContext)
        servletContext.addListener(RequestContextListener::class.java)
        servletContext.setInitParameter("spring.profiles.active", "dev")
    }

}