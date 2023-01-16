import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
//    application
    war
    id("com.google.devtools.ksp").version("1.6.10-1.0.4") // Or latest version of KSP
}

val okhttpVersion = properties["okhttpVersion"]
group = "com.main.platform.workspace"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.arrow-kt:arrow-core:1.1.2")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.0.1")
    implementation("io.arrow-kt:arrow-fx-stm:1.0.1")

    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:4.0.1")
    compileOnly("jakarta.servlet:jakarta.servlet-api:5.0.0")
    compileOnly("jakarta.mvc:jakarta.mvc-api:2.1.0")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    // https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")

    compileOnly("jakarta.servlet.jsp:jakarta.servlet.jsp-api:3.1.0")
    implementation("com.google.code.gson:gson:2.10.1")

// https://mvnrepository.com/artifact/com.beust/klaxon
//    implementation("com.beust:klaxon:5.6")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    // https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")
// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp-bom
//    implementation("com.squareup.okhttp3:okhttp-bom:$okhttpVersion")

//    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
    // https://mvnrepository.com/artifact/com.squareup.moshi/moshi
    runtimeOnly("com.squareup.moshi:moshi:1.14.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
//		freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}