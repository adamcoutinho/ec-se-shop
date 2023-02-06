package com.main.application.connector

import com.main.core.v1.controller.auth.AuthController
import com.main.core.v1.controller.auth.AuthControllerImpl
import com.main.core.v1.controller.registeruser.RegisterUserControllerImpl
import com.main.core.v1.port.persistence.RegisterUserRepositoryPort
import com.main.core.v1.port.persistence.UserRepositoryPort
import com.main.platform.adapter.postgres.v1.adapter.RegisterUserJpaRepositoryAdapter
import com.main.platform.adapter.postgres.v1.adapter.UserJpaRepositoryAdapter
import com.main.platform.adapter.postgres.v1.jpa.RegisterUserJpaRepository
import com.main.platform.adapter.postgres.v1.jpa.UserJpaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class BeanConnector {

    @Bean
    open fun userRepositoryPort(userJpaRepository: UserJpaRepository): UserRepositoryPort =
        UserJpaRepositoryAdapter(
            userJpaRepository = userJpaRepository
        )

    @Bean
    open fun authController(userRepositoryPort: UserRepositoryPort): AuthController =
        AuthControllerImpl(userRepositoryPort = userRepositoryPort)

    @Bean
    open fun registerUserRepositoryPort(registerUserJpaRepository: RegisterUserJpaRepository) =
        RegisterUserJpaRepositoryAdapter(
            registerUserJpaRepository = registerUserJpaRepository
        )

    @Bean
    open fun registerUserController(registerUserRepositoryPort: RegisterUserRepositoryPort) =
        RegisterUserControllerImpl(
            registerUserRepositoryPort = registerUserRepositoryPort
        )
}