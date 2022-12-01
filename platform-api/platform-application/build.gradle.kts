import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
}

repositories {
    mavenCentral()
}



dependencies {
    implementation("org.springframework.boot:spring-boot-starter:2.7.5")
    implementation("org.springframework.boot:spring-boot-configuration-processor:2.7.5")
    implementation("io.klogging:klogging-jvm:0.4.9")
    implementation("org.springframework.data:spring-data-jpa:2.7.5")

    implementation(project(":core"))
    implementation(project(":platform-api:adapter:platform-entrypoint-rest"))
    implementation(project(":platform-api:adapter:platform-persistence-postgres"))
    implementation(kotlin("stdlib-jdk8"))

}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}