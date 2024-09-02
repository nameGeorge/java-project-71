plugins {
    id("java")

    application
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

dependencies {
    implementation("info.picocli:picocli:4.7.6")
    implementation ("org.litote.jackson:jackson-generator:0.4.0")
    implementation ("com.konghq:unirest-objectmapper-jackson:4.0.0-RC7")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.1")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}