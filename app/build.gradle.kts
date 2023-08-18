plugins {
    id("parrot-android-app-plugin")
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
    implementation(libs.androidx.appcompat)
    implementation(libs.activity.ktx)
    implementation(libs.google.android.material)

    // Features
    implementation(project(":features:main-screen"))

    androidTestImplementation(libs.espresso.core)
}