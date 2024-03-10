pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "lessons"

rootDir.listFiles()?.forEach {
    if (it.isDirectory && it.list()?.contains("build.gradle.kts") == true) {
        include(it.name)
    }
}
