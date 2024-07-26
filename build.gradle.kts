plugins {
    kotlin("jvm") version "2.0.0"
    `maven-publish`
}

group = "com.abusabda.hisab-astronomis"
version = "1.0.0"

publishing {
    publications {
        create<MavenPublication>("Maven") {
            from(components["java"])
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}