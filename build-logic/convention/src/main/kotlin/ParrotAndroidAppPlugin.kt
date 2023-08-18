import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A plugin specifically for applying to "app" modules.
 *
 * This plugin is designed to be applied to the "app" modules of an Android project.
 * It configures the module to apply necessary Android and Kotlin plugins, as well as custom Parrot plugins.
 * Additionally, it adjusts target SDK and adds relevant dependencies to the project.
 *
 * Usage:
 * Apply this plugin to an "app" module's build.gradle.kts file to configure it for the Android application:
 *
 * apply("parrot-android-app-plugin")
 *
 * The simple name is defined in "buildSrc/build.gradle.kts".
 *
 * Note: This plugin should be applied to the "app" module only.
 * If applied to other module types, unexpected behavior may occur.
 */
class ParrotAndroidAppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.run {
            apply("com.android.application")
            apply("parrot-android-base-plugin")
            apply("parrot-compose-plugin")
            apply("parrot-anvil-plugin")
        }

        val appComponents =
            project.extensions.getByType(ApplicationAndroidComponentsExtension::class.java)

        appComponents.finalizeDsl { extension ->
            with(extension) {
                defaultConfig {
                    targetSdk = ParrotJavaVersions.TARGET_SDK
                }

                if (this is AppExtension) {
                    buildTypes {
                        maybeCreate("release")
                        getByName("release").run {
                            isMinifyEnabled = true
                            isShrinkResources = true
                            proguardFiles(
                                extension.getDefaultProguardFile("proguard-android-optimize.txt"),
                                "proguard-rules.pro"
                            )
                        }
                    }
                }
            }
        }

        project.dependencies.add(
            "implementation",
            project.dependencies.platform(project.libs("kotlin.bom"))
        )
    }
}