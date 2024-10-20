
import com.google.cloud.tools.gradle.appengine.appyaml.AppEngineAppYamlExtension

plugins {
//    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    id("com.gradleup.shadow") version "8.3.1"
    id("com.google.cloud.tools.appengine") version "2.8.0"
    application
    kotlin("jvm")
}

group = "kr.co.vcnc.playground.kmp"
version = "1.0.0"
application {
    mainClass.set("kr.co.vcnc.playground.kmp.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    testImplementation(libs.kotlin.test.junit)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.kotlin.datetime)
    implementation(kotlin("stdlib-jdk8"))
}

configure<AppEngineAppYamlExtension> {
    stage {
        setArtifact("build/libs/${project.name}-all.jar")
    }
    deploy {
        version = "GCLOUD_CONFIG"
        projectId = "GCLOUD_CONFIG"
    }
}
repositories {
    mavenCentral()
}