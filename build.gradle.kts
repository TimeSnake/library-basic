plugins {
    id("java")
    id("java-base")
    id("java-library")
    id("maven-publish")
}


group = "de.timesnake"
version = "2.1.1"
var projectId = 6

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://git.timesnake.de/api/v4/groups/7/-/packages/maven")
        name = "timesnake"
        credentials(PasswordCredentials::class)
    }
}

dependencies {
    compileOnly("net.kyori:adventure-api:4.11.0")
    compileOnly("com.google.code.gson:gson:2.10.1")

    compileOnly("org.apache.logging.log4j:log4j-api:2.22.1")
    compileOnly("org.apache.logging.log4j:log4j-core:2.22.1")
}

publishing {
    repositories {
        maven {
            url = uri("https://git.timesnake.de/api/v4/projects/$projectId/packages/maven")
            name = "timesnake"
            credentials(PasswordCredentials::class)
        }
    }

    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release = 21
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    withSourcesJar()
}