plugins {
    id("build-jvm")
    id("build-kmp") apply false
}

group = rootProject.group
version = rootProject.version

dependencies {
    api(libs.kotlinx.datetime)
}