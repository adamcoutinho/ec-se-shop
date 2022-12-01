import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    war
}

group = "com.main"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/org.springframework/spring-webmvc
    implementation("org.springframework:spring-webmvc:5.3.23")
// https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
    // https://mvnrepository.com/artifact/javax.servlet.jsp/javax.servlet.jsp-api
    compileOnly("javax.servlet.jsp:javax.servlet.jsp-api:2.3.3")
// https://mvnrepository.com/artifact/javax.servlet/jstl
//    implementation("javax.servlet:jstl:1.2")
// https://mvnrepository.com/artifact/org.jboss.spec.javax.servlet.jstl/jboss-jstl-api_1.2_spec
    compileOnly("org.jboss.spec.javax.servlet.jstl:jboss-jstl-api_1.2_spec:1.1.4.Final")
// https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
    implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")

// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.10")
// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp-urlconnection
    implementation("com.squareup.okhttp3:okhttp-urlconnection:5.0.0-alpha.10")
// https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.10")
// https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10")
    implementation(kotlin("stdlib-jdk8"))


}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}