package hellokevin.gradle.plugins

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

/**
 * Get a dependency from the project's version catalog.
 *
 * This function provides a convenient way to access dependencies defined in the project's version catalog.
 * It retrieves a specific dependency from the "libs" version catalog and returns its version. I wish this wasn't necessary,
 * but I'm not sure of a better way to access the gradle/libs.versions.toml file versions from buildSrc.
 *
 * Usage:
 * Call this function to get the version of a specific dependency from the "libs" version catalog:
 *
 * val dependencyVersion = project.libs("dependencyName")
 *
 * This function helps centralize dependency management and version control by accessing dependencies
 * defined in the project's version catalog.
 *
 * Note: This function is useful for simplifying dependency version retrieval and ensuring consistent
 * version management across modules in the project.
 *
 * @param lib The name of the dependency to retrieve.
 * @return The version of the specified dependency from the "libs" version catalog.
 */
fun Project.libs(lib: String) =
    extensions.getByType(VersionCatalogsExtension::class).named("libs").findLibrary(lib).get().get()