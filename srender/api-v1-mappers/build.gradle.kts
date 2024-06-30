plugins {
    id("build-jvm")
}

group = rootProject.group
version = rootProject.version

sourceSets {
    main {
        java.srcDir("src/main/kotlin")
    }

    test {
        java.srcDir("src/main/test")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":api-v1-jackson"))
    implementation(project(":common"))

    testImplementation(kotlin("test-junit"))
}