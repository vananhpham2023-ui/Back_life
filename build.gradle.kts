plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.ktlint) apply false
}

val libsCatalog = extensions.getByType<org.gradle.api.artifacts.VersionCatalogsExtension>()
    .named("libs")
val detektVersion = libsCatalog.findVersion("detekt").get().requiredVersion
val ktlintVersion = libsCatalog.findVersion("ktlint").get().requiredVersion

val detektConfigFile = rootProject.file("config/detekt/detekt.yml")

tasks.register("detekt") {
    group = "verification"
    description = "Runs detekt for all modules."
}

tasks.register("ktlintCheck") {
    group = "verification"
    description = "Runs ktlint for all modules."
}

subprojects {
    pluginManager.apply("io.gitlab.arturbosch.detekt")
    pluginManager.apply("org.jlleitschuh.gradle.ktlint")

    plugins.withId("io.gitlab.arturbosch.detekt") {
        extensions.configure<io.gitlab.arturbosch.detekt.extensions.DetektExtension> {
            config.setFrom(files(detektConfigFile))
            buildUponDefaultConfig = true
            allRules = false
            toolVersion = detektVersion
            basePath = rootProject.projectDir.absolutePath
        }

        tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
            jvmTarget = "17"
            exclude("**/build/**", "**/generated/**", "**/schema/**", "**/schemas/**")
            reports {
                xml.required.set(true)
                html.required.set(true)
                txt.required.set(false)
                sarif.required.set(false)
            }
        }

        rootProject.tasks.named("detekt").configure {
            dependsOn(tasks.named("detekt"))
        }
    }

    plugins.withId("org.jlleitschuh.gradle.ktlint") {
        extensions.configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
            version.set(ktlintVersion)
            filter {
                exclude("**/build/**")
                exclude("**/generated/**")
                exclude("**/schema/**")
                exclude("**/schemas/**")
            }
        }

        rootProject.tasks.named("ktlintCheck").configure {
            dependsOn(tasks.named("ktlintCheck"))
        }
    }
}
