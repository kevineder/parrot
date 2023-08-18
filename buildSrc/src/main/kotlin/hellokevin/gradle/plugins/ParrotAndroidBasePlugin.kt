package hellokevin.gradle.plugins

import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

/**
 * A base plugin for applying to all modules.
 *
 * This plugin is designed to be applied to all Android modules in this project.
 * It configures common settings and dependencies for Android modules such as
 * compileSdk, defaultConfig, packaging, build types, compile options, and Kotlin settings.
 *
 * Usage:
 * Apply this plugin to an Android project's build.gradle.kts file to apply the common
 * configuration to all Android modules:
 *
 * apply("parrot-android-base-plugin")
 *
 * The simple name is defined in "buildSrc/build.gradle.kts".
 *
 * The plugin will handle the configuration of compileSdk, defaultConfig, packaging, build types,
 * compile options, and Kotlin settings. It also applies other necessary plugins like
 * "org.jetbrains.kotlin.android" and "kotlin-kapt".
 *
 * This plugin assumes that the version constants and dependencies are defined in the project.
 * Make sure to have the necessary dependencies and version constants defined.
 *
 * Note: This plugin is meant to be used as a part of a larger plugin-based setup.
 * Individual module-specific plugins like [ParrotAndroidAppPlugin] apply this automatically.
 */
class ParrotAndroidBasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.run {
            apply("org.jetbrains.kotlin.android")
        }

        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)

        androidComponents.finalizeDsl { extension ->
            extension.apply {
                compileSdk = ParrotJavaVersions.COMPILE_SDK
                defaultConfig {
                    minSdk = ParrotJavaVersions.MIN_SDK
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                project.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        apiVersion = ParrotJavaVersions.JAVA_VERSION_STRING
                        languageVersion = ParrotJavaVersions.JAVA_VERSION_STRING
                    }
                }

                project.tasks.withType(KotlinJvmCompile::class.java).configureEach {
                    kotlinOptions.jvmTarget = ParrotJavaVersions.JAVA_VERSION_STRING
                }
            }
        }
    }
}