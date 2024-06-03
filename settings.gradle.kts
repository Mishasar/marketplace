pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion
        id("build-jvm") apply false
        id("build-kmp") apply false
        id("com.bmuschko.docker-remote-api") version "9.4.0"
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "ok-srender-202312"

includeBuild("lessons")
includeBuild("srender")
