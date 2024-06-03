plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "com.otus.otuskotlin.marketplace"
version = "0.0.1"

repositories {
    mavenCentral()
}

subprojects {
    repositories {
        mavenCentral()
    }
    group = rootProject.group
    version = rootProject.version
}

application.mainClass.set("ru.saraykin.srender.app.MainKt")

val fatJar by tasks.register<Jar>("fatJar") {
    manifest {
        attributes("Main-Class" to "ru.saraykin.srender.app.MainKt")
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}
