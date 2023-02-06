package com.main.websites.v1.config

import com.main.websites.v1.config.contants.*
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.web.accept.ContentNegotiationManager
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = [PACKAGE_PATH])
open class WebMvcConfig : WebMvcConfigurer {
    @Bean
    open fun resolver(): InternalResourceViewResolver {
        val resolver = InternalResourceViewResolver()
        resolver.setViewClass(JstlView::class.java)
        resolver.setPrefix(SITES_DIR)
        resolver.setSuffix(EXTENSION_FILE)
        return resolver
    }

    @Bean
    open fun contentNegotiationViewResolver(manager: ContentNegotiationManager?): ViewResolver {
        val viewResolvers: MutableList<ViewResolver> = ArrayList()
        viewResolvers.add(resolver())
        viewResolvers.add(JsonViewResolver())
        val resolver = ContentNegotiatingViewResolver()
        resolver.viewResolvers = viewResolvers
        resolver.contentNegotiationManager = manager
        return resolver
    }

    @Bean
    open fun messageSource(): MessageSource {
        val messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasename(MESSAGE_DIR)
        messageSource.setDefaultEncoding(TYPE_ENCONDING_FILE)
        messageSource.setCacheSeconds(1)
        return messageSource
    }


    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/")
    }


}