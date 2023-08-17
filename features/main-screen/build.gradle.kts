plugins {
    id("parrot-feature-plugin")
}

android {
    namespace = "hellokevin.parrot.features.mainscreen"
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.core)
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)
    implementation(libs.moshi.kotlin)
}