plugins {
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jdbc
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.7.5")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.5")
// https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
//    implementation("org.springframework.data:spring-data-jpa:2.7.5")
// https://mvnrepository.com/artifact/org.springframework.data/spring-data-jdbc
//    implementation("org.springframework.data:spring-data-jdbc:2.4.5")

//    runtimeOnly("org.postgresql:postgresql")
    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.5.0")
    implementation(project(":core"))
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
val compileTestKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}