package com.main.platform.config

import com.main.core.platform.controller.AuthenticatingController
import com.main.core.platform.controller.RegisterCustomerController
import com.main.core.platform.controller.impl.AuthenticatingControllerImpl
import com.main.core.platform.controller.impl.RegisterAccountControllerImpl
import com.main.core.platform.controller.impl.RegisterCustomerControllerImpl
import com.main.core.platform.port.persistence.RegisterAccountPort
import com.main.core.platform.port.persistence.RegisterCustomerPort
import com.main.core.platform.port.persistence.RegisterKeyPort
import com.main.core.platform.port.persistence.RegisterPasswordPort
import com.main.persistence.postgres.adapter.AccountJpaRepositoryAdapter
import com.main.persistence.postgres.adapter.CustomerJpaRepositoryAdapter
import com.main.persistence.postgres.adapter.KeyJpaRepositoryAdapter
import com.main.persistence.postgres.adapter.PasswordJpaRepositoryAdapter
import com.main.persistence.postgres.database.jpa.AccountJpaRepository
import com.main.persistence.postgres.database.jpa.CustomerJpaRepository
import com.main.persistence.postgres.database.jpa.KeyJpaRepository
import com.main.persistence.postgres.database.jpa.PasswordJpaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

    @Bean
    fun authenticationController(
        registerAccountPort: RegisterAccountPort,
        registerPasswordPort: RegisterPasswordPort,
        registerKeyPort: RegisterKeyPort
    ):AuthenticatingController = AuthenticatingControllerImpl(
        registerAccountPort = registerAccountPort,
        registerPasswordPort = registerPasswordPort,
        registerKeyPort = registerKeyPort
    )

    @Bean
    fun registerCustomerController(
        registerCustomerPort: RegisterCustomerPort,
        registerAccountPort: RegisterAccountPort
    ): RegisterCustomerController =
        RegisterCustomerControllerImpl(registerCustomerPort, registerAccountPort)

    @Bean
    fun registerAccountPort(accountJpaRepository: AccountJpaRepository) =
        AccountJpaRepositoryAdapter(accountJpaRepository)

    @Bean
    fun registerKeyPort(keyJpaRepository: KeyJpaRepository) =
        KeyJpaRepositoryAdapter(keyJpaRepository)

    @Bean
    fun registerPasswordPort(passwordJpaRepository: PasswordJpaRepository) =
        PasswordJpaRepositoryAdapter(passwordJpaRepository)

    @Bean
    fun registerAccountController(
        registerAccountPort: RegisterAccountPort,
        registerPasswordPort: RegisterPasswordPort,
        registerKeyPort: RegisterKeyPort
    ) =
        RegisterAccountControllerImpl(
            registerAccountPort = registerAccountPort,
            registerKeyPort = registerKeyPort,
            registerPasswordPort = registerPasswordPort
        )

    @Bean
    fun registerCustomerPort(customerJpaRepository: CustomerJpaRepository): RegisterCustomerPort =
        CustomerJpaRepositoryAdapter(
            customerJpaRepository = customerJpaRepository
        )

}