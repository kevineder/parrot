package hellokevin.gradle.plugins

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.ApplicationVariant
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

/**
 * A plugin for applying Hilt dependencies to a module.
 *
 * This plugin adds necessary Hilt dependencies to an Android module. It configures the
 * annotation processor ("kapt") and implementation dependencies for Hilt.
 *
 * Usage:
 * Apply this plugin to an Android module's build.gradle.kts file to add Hilt dependencies:
 *
 * apply("parrot-hilt-plugin")
 *
 * The simple name is defined in "buildSrc/build.gradle.kts".
 *
 * The plugin adds "kapt" dependency for the Hilt annotation processor and "implementation"
 * dependency for the Hilt Android library. It assumes that the version constants and dependencies
 * are defined in the project. Make sure to have the required dependencies and version constants set up.
 */
class ParrotHiltPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.dependencies.add("kapt", project.libs("hilt.compiler"))
        project.dependencies.add("implementation", project.libs("hilt.android"))
        project.dependencies.add("implementation", project.libs("javax.inject"))

        project.plugins.withType(KotlinPluginWrapper::class.java) {
            project.extensions.configure<KaptExtension>("kapt") {
                correctErrorTypes = true
            }
        }
    }
}