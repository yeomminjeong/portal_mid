var springVersion: String = ""

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
ext {
    springVersion = "6.0.7"
}


dependencies {
    implementation("org.springframework:spring-core:${springVersion}")
    implementation("org.springframework:spring-context:${springVersion}")
    implementation("org.springframework:spring-jdbc:${springVersion}")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.hamcrest:hamcrest:2.2")
    runtimeOnly("mysql:mysql-connector-java:8.0.32")
}

tasks.test {
    useJUnitPlatform()
}