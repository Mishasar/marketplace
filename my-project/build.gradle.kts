import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage
import com.bmuschko.gradle.docker.tasks.image.DockerPushImage
import com.bmuschko.gradle.docker.tasks.container.DockerCreateContainer
import com.bmuschko.gradle.docker.tasks.container.DockerStartContainer

plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    id("com.bmuschko.docker-remote-api") version "9.4.0"
}

group = "ru.saraykin.my.project.app"
version = "0.0.1"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    repositories {
        mavenCentral()
    }
    group = rootProject.group
    version = rootProject.version
}

// https://hub.docker.com/layers/mishasar/test-app/latest/images/sha256-1e52771b58c34e0fe263d4c117dfc1aaaf6649a69deccdf238ffcc23ab1777ed?context=repo
docker {
    url = "unix:///var/run/docker.sock"
    registryCredentials {
        url = "https://hub.docker.com/v1/"
        username = System.getenv("DOCKER_USER")
        password = System.getenv("DOCKER_PASS")
    }
}

val buildAppImage by tasks.register<DockerBuildImage>("buildAppImage") {
    dependsOn("app:jar")
    dockerFile = project.file("./Dockerfile")
    inputDir = project.projectDir
    images.add("mishasar/test-app:latest")
}

val pushImage by tasks.register<DockerPushImage>("pushImage") {
    dependsOn("buildAppImage")
    images.add("mishasar/test-app:latest")
}

val createContainer by tasks.register<DockerCreateContainer>("createContainer") {
    dependsOn(buildAppImage)
    targetImageId(buildAppImage.imageId)
    containerName.set("test-app")
}

val startContainer by tasks.register<DockerStartContainer>("startContainer") {
    dependsOn(createContainer)
    targetContainerId(createContainer.containerId)
}
