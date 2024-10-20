rootProject.name = "KMPPlayground"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("android.*")
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("org\\.jetbrains.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("com.google.cloud.tools.appengine")) {
                useModule("com.google.cloud.tools:appengine-gradle-plugin:${requested.version}")
            }
        }
    }
    plugins {
        kotlin("jvm") version "2.0.21"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupByRegex("androidx.*")
                includeGroupByRegex("android.*")
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("org\\.jetbrains.*")
                maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":server")
include(":shared")