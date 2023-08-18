import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    alias(libs.plugins.kotlin.android) apply false
}

group = "hellokevin.buildlogic"

dependencies {
    compileOnly(libs.agp)
    compileOnly(libs.kgp)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

gradlePlugin {
    plugins {
        register("parrot-android-base-plugin") {
            id = "parrot-android-base-plugin"
            implementationClass = "ParrotAndroidBasePlugin"
        }

        register("parrot-android-app-plugin") {
            id = "parrot-android-app-plugin"
            implementationClass = "ParrotAndroidAppPlugin"
        }

        register("parrot-android-feature-plugin") {
            id = "parrot-android-feature-plugin"
            implementationClass = "ParrotAndroidFeaturePlugin"
        }

        register("parrot-compose-plugin") {
            id = "parrot-compose-plugin"
            implementationClass = "ParrotComposePlugin"
        }

        register("parrot-hilt-plugin") {
            id = "parrot-hilt-plugin"
            implementationClass = "ParrotHiltPlugin"
        }

        register("parrot-anvil-plugin") {
            id = "parrot-anvil-plugin"
            implementationClass = "ParrotAnvilPlugin"
        }

        register("parrot-android-library-plugin") {
            id = "parrot-android-library-plugin"
            implementationClass = "ParrotAndroidLibraryPlugin"
        }
    }
}

//repositories {
//    google()
//    mavenCentral()
//}
//
//dependencies {
//    compileOnly(gradleApi())
//
//    // Once this is updated, we can remove the the "suppressUnsupportedCompileSdk" in gradle.properties.
//    implementation("com.android.tools.build:gradle:8.0.2")
//    implementation(kotlin("gradle-plugin", "1.3.50"))
//    implementation(kotlin("android-extensions"))
//
//    implementation("org.jacoco:org.jacoco.core:0.8.10")
//}