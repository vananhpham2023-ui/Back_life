pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LingHui"

include(
    ":app",
    ":core-domain",
    ":core-ui",
    ":data-local",
    ":feature-home",
    ":feature-tasks",
    ":feature-logs",
    ":feature-me",
)
