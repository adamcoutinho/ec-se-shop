package com.main.platform

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = [
    PLATFORM_MAIN,
    PLATFORM_ENTRYPOINT_REST
])
@EntityScan(basePackages = [PLATFORM_PERSISTENCE_POSTGRES_ENTITY])
@EnableJpaRepositories(basePackages = [PLATFORM_PERSISTENCE_POSTGRES_JPA_REPOSITORY])
class PlatformApplication

fun main(args: Array<String>) {
    runApplication<PlatformApplication>(*args)
}