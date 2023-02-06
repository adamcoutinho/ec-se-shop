package com.main.websites.v1.config

import org.springframework.web.servlet.View
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.view.json.MappingJackson2JsonView
import java.util.*


class JsonViewResolver : ViewResolver {
    @Throws(Exception::class)
    override fun resolveViewName(viewName: String, locale: Locale): View {
        val view = MappingJackson2JsonView()
        view.setPrettyPrint(true)
        return view
    }
}
