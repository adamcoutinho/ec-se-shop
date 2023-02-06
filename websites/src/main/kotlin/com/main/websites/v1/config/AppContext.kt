package com.main.websites.v1.config

import com.main.websites.v1.config.contants.PROPERTIES_PATH
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import java.util.*


@Configuration
@PropertySource(PROPERTIES_PATH)
open class AppContext {

    @Autowired
    private val environment: Environment? = null


}