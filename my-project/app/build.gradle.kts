plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "ru.saraykin.my.project.app.MainKt")
    }
}
