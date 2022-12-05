package com.main.application.connector

import com.main.core.v1.controller.auth.AuthController
import com.main.core.v1.controller.auth.AuthControllerImpl
import com.main.core.v1.port.persistence.UserRepositoryPort
import com.main.platform.adapter.postgres.v1.adapter.UserJpaRepositoryAdapter
import com.main.platform.adapter.postgres.v1.jpa.UserJpaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
class BeanConnector {

    @Bean
    fun userRepositoryPort(userJpaRepository: UserJpaRepository): UserRepositoryPort =
        UserJpaRepositoryAdapter(
            userJpaRepository = userJpaRepository
        )

    @Bean
    fun authController(userRepositoryPort: UserRepositoryPort): AuthController =
        AuthControllerImpl(userRepositoryPort =userRepositoryPort)
}