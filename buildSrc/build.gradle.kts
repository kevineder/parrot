plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.android) apply false
}

dependencies {
    implementation(libs.agp)
    implementation(libs.kgp)
}

gradlePlugin {
    plugins {
        register("parrot-base-plugin") {
            id = "parrot-base-plugin"
            implementationClass = "hellokevin.gradle.plugins.ParrotBasePlugin"
        }

        register("parrot-app-plugin") {
            id = "parrot-app-plugin"
            implementationClass = "hellokevin.gradle.plugins.ParrotAppPlugin"
        }

        register("parrot-feature-plugin") {
            id = "parrot-feature-plugin"
            implementationClass = "hellokevin.gradle.plugins.ParrotFeaturePlugin"
        }

        register("parrot-compose-plugin") {
            id = "parrot-compose-plugin"
            implementationClass = "hellokevin.gradle.plugins.ParrotComposePlugin"
        }

        register("parrot-hilt-plugin") {
            id = "parrot-hilt-plugin"
            implementationClass = "hellokevin.gradle.plugins.ParrotHiltPlugin"
        }

        register("parrot-anvil-plugin") {
            id = "parrot-anvil-plugin"
            implementationClass = "hellokevin.gradle.plugins.ParrotAnvilPlugin"
        }

        register("parrot-library-plugin") {
            id = "parrot-library-plugin"
            implementationClass = "hellokevin.gradle.plugins.ParrotLibraryPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())

    // Once this is updated, we can remove the the "suppressUnsupportedCompileSdk" in gradle.properties.
    implementation("com.android.tools.build:gradle:8.0.2")
    implementation(kotlin("gradle-plugin", "1.3.50"))
    implementation(kotlin("android-extensions"))

    implementation("org.jacoco:org.jacoco.core:0.8.10")
}