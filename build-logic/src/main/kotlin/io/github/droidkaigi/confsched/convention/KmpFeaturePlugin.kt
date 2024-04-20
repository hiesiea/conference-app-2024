package io.github.droidkaigi.confsched.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KmpFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("droidkaigi.primitive.kmp")
                apply("droidkaigi.primitive.kmp.android")
                apply("droidkaigi.primitive.kmp.ios")
                apply("droidkaigi.primitive.kmp.compose")
                apply("droidkaigi.primitive.kmp.android.hilt")
                apply("droidkaigi.primitive.kmp.roborazzi")
                apply("droidkaigi.primitive.detekt")
            }

            tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    freeCompilerArgs = freeCompilerArgs + buildComposeMetricsParameters()
                }
            }
        }
    }
}