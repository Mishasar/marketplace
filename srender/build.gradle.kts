import com.bmuschko.gradle.docker.tasks.container.DockerCreateContainer
import com.bmuschko.gradle.docker.tasks.container.DockerStartContainer
import com.bmuschko.gradle.docker.tasks.image.*


group = "ru.saraykin.my.project.app"
version = "0.0.1"

plugins {
    id("com.bmuschko.docker-remote-api") version "9.4.0"
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
    url.set("unix:///var/run/docker.sock")
    registryCredentials {
        url.set("https://hub.docker.com/v1/")
        username.set(System.getenv("DOCKER_USER"))
        password.set(System.getenv("DOCKER_PASS"))
    }
}

val containerName = "srender"

val buildAppImage by tasks.register<DockerBuildImage>("buildAppImage") {
    dependsOn("app:jar")
    dockerFile.set(project.file("./docker/Dockerfile"))
    inputDir.set(project.projectDir)
    images.add("mishasar/${containerName}:latest")
}

val pushImage by tasks.register<DockerPushImage>("pushImage") {
    dependsOn("buildAppImage")
    images.add("mishasar/${containerName}:latest")
}

val createContainer by tasks.register<DockerCreateContainer>("createContainer") {
    dependsOn(buildAppImage)
    targetImageId(buildAppImage.imageId)
    containerName.set(containerName)
}

val startContainer by tasks.register<DockerStartContainer>("startContainer") {
    dependsOn(createContainer)
    targetContainerId(createContainer.containerId)
}