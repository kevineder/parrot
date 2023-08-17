plugins {
    id("parrot-app-plugin")
}

android {
    namespace = "hellokevin.parrot"

    defaultConfig {
        applicationId = "hellokevin.parrot"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
//    implementation(platform(libs.kotlin.bom))
    implementation(libs.androidx.appcompat)
    implementation(libs.activity.ktx)
    implementation(libs.google.android.material)
//    implementation(libs.compose.navigation)
//    implementation(libs.compose.material3)

    // Features
    implementation(project(":features:main-screen"))

    androidTestImplementation(libs.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}