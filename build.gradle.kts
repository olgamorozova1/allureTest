plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("io.rest-assured:rest-assured:4.4.0")
    testImplementation ("io.rest-assured:json-schema-validator:4.4.0")
    testImplementation ("io.qameta.allure:allure-junit5:2.14.0")
}

tasks.test {
    useJUnitPlatform()
}