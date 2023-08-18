package hellokevin.gradle.plugins

import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.plugins

class ParrotAnvilPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.run {
            apply("com.squareup.anvil")
        }
    }
}