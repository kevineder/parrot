import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A plugin that enables Jetpack Compose and configures Compose-related dependencies.
 *
 * This plugin applies necessary settings to enable Jetpack Compose in an Android project.
 * It configures build features and adds Compose-related dependencies to the project.
 *
 * Usage:
 * Apply this plugin to your Android project's build.gradle.kts file to enable Jetpack Compose:
 *
 * apply("parrot-compose-plugin")
 *
 * The simple name is defined in "buildSrc/build.gradle.kts".
 */
class ParrotComposePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponents.finalizeDsl { extension ->
            extension.apply {
                buildFeatures.compose = true

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.1"
                }
            }
        }

        project.dependencies.add("implementation", project.libs("compose.navigation"))
        project.dependencies.add("implementation", project.libs("compose.material3"))
        project.dependencies.add("implementation", project.libs("compose.ui.graphics"))
        project.dependencies.add("debugImplementation", project.libs("compose.ui.tooling"))
        project.dependencies.add("debugImplementation", project.libs("compose.ui.tooling.preview"))
        project.dependencies.add("implementation", project.dependencies.platform(project.libs("compose.bom")))
    }
}