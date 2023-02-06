import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    war
    kotlin("jvm") version "1.6.21"
}

group = "com.main"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

val springVersion = properties["spring-version"]
val tomcatServletApiVersion = properties["tomcatServletApiVersion"]
val tomcatJspApiVersion= properties["tomcatJspApiVersion"]
val jstlVersion = properties["jstlVersion"]
val jacksonVersion = properties["jacksonVersion"]

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.apache.tomcat:tomcat-servlet-api:$tomcatServletApiVersion")
    implementation("org.apache.tomcat:tomcat-jsp-api:$tomcatJspApiVersion")
    implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("org.springframework:spring-webmvc:$springVersion")
    implementation("org.springframework:spring-context-support:$springVersion")
    implementation("org.springframework:spring-context:$springVersion")
    implementation("org.springframework:spring-web:$springVersion")
    implementation("org.springframework:spring-core:$springVersion")
    implementation("org.springframework:spring-beans:$springVersion")
    implementation("org.springframework:spring-aop:$springVersion")
    implementation("javax.servlet:jstl:$jstlVersion")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
//        jvmTarget = "17"
//    }
//}

tasks.withType<Test> {
    useJUnitPlatform()
}
