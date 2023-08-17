# Parrot

Parrot is a toy project designed to explore multi-module Android configurations and Android Media3. This project serves as a learning playground for experimenting with various Android architecture and features.

## Table of Contents

- [Overview](#overview)
- [Plugins](#plugins)
- [Dependency Management](#dependency-management)
- [License](#license)

## Overview

Parrot is a multi-module Android project that focuses on experimenting with different Android architecture patterns and features. The primary goal is to provide a sandbox for learning and trying out new concepts related to Android app development.

## Plugins

The project leverages several custom plugins created in the `buildSrc` directory to streamline the development process. These plugins offer pre-configured settings and dependencies for different module types:

- **ParrotBasePlugin**: This base plugin should be applied to all Android modules in the project. It configures common settings and dependencies, such as compileSdk, defaultConfig, packaging, build types, compile options, and Kotlin settings. It also applies other necessary plugins like "org.jetbrains.kotlin.android" and "kotlin-kapt."

- **ParrotAppPlugin**: This plugin is specifically designed for applying to "app" modules. It automatically applies essential plugins like "com.android.application," "org.jetbrains.kotlin.android," "parrot-base-plugin," and "parrot-compose-plugin." It configures the targetSdk and applies common settings to the "app" module.
 
- **ParrotFeaturePlugin**: This plugin should be applied to Android feature modules. It applies the necessary plugins like "com.android.library," "org.jetbrains.kotlin.android," "parrot-base-plugin," and "parrot-compose-plugin."
 
- **ParrotComposePlugin**: This plugin enables Jetpack Compose and configures related dependencies for Android modules. It handles settings related to Jetpack Compose, such as enabling build features and specifying the Kotlin compiler extension version.

- **ParrotHiltPlugin**: This plugin adds Hilt-related dependencies to the module where it's applied. It simplifies the process of adding Hilt's annotation processor and runtime dependencies.

## Dependency Management

Parrot uses a `libs.versions.toml` file to manage dependencies and their versions. This approach centralizes version control, ensuring consistent dependency versions across modules. The custom `libs` function in the `buildSrc` directory simplifies the retrieval of dependency versions defined in the version catalog.

## License

This project is licensed under the [MIT License](LICENSE).
