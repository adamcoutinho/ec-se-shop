package com.main.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(
    scanBasePackages = [
        PLATFORM_PACKAGE_MAIN,
        PLATFORM_PACKAGE_CORE_V1,
        PLATFORM_PACKAGE_REST_V1
    ]
)
@EntityScan(basePackages = [PLATFORM_PACKAGE_POSTGRES_ADAPTER_ENTITY_V1])
@EnableJpaRepositories(basePackages = [PLATFORM_PACKAGE_POSTGRES_ADAPTER_JPA_V1])
open class PlatformApplication

fun main(args: Array<String>) {
    runApplication<PlatformApplication>(*args)
}
