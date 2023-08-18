package hellokevin.gradle.plugins

import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A plugin for applying to feature modules.
 *
 * This plugin is designed to be applied to Android feature modules in this project.
 * It configures the necessary settings and dependencies for feature modules, including
 * applying "com.android.library" and other common plugins like "org.jetbrains.kotlin.android".
 *
 * Usage:
 * Apply this plugin to an Android feature module's build.gradle.kts file:
 *
 * apply("parrot-feature-plugin")
 *
 * The simple name is defined in "buildSrc/build.gradle.kts".
 *
 * The plugin applies necessary plugins for Android library modules, Kotlin settings, and other
 * common configurations. It assumes that the version constants and dependencies are defined
 * in the project. Ensure that you have the required dependencies and version constants set up.
 *
 * Note: This plugin is meant to be part of a larger plugin-based setup. It automatically applies
 * the necessary common plugins like [ParrotBasePlugin], [ParrotComposePlugin] and [ParrotAnvilPlugin].
 */
class ParrotFeaturePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.run {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
            apply("parrot-base-plugin")
            apply("parrot-compose-plugin")
            apply("parrot-anvil-plugin")
        }
    }
}