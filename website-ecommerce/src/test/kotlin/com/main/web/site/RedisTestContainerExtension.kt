
package com.main.web.site

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.testcontainers.containers.GenericContainer
import java.util.concurrent.atomic.AtomicBoolean

class RedisTestContainerExtension : BeforeAllCallback {
    private val started = AtomicBoolean(false)

    companion object {
        @JvmStatic
        val redis = KGenericContainer("redis:6.2.6").withExposedPorts(6379)
    }

    @Throws(Exception::class)
    override fun beforeAll(extensionContext: ExtensionContext) {
        if (!started.get()) {
            redis.start()
            System.setProperty("jhipster.cache.redis.server", "redis://${redis.containerIpAddress}:${redis.getMappedPort(6379)}")
            started.set(true)
        }
    }

    // Workaround for Testcointainers issue https://github.com/testcontainers/testcontainers-java/issues/318#issuecomment-290692749
    class KGenericContainer(imageName: String) : GenericContainer<KGenericContainer>(imageName)
}
