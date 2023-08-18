package hellokevin.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class ParrotAndroidLibraryPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.run {
            apply("com.android.library")
            apply("parrot-android-base-plugin")
        }
    }
}