package hellokevin.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class ParrotLibraryPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.run {
            apply("com.android.library")
            apply("parrot-base-plugin")
        }
    }
}