plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.android.library.compose)
    alias(libs.plugins.formulaone.android.library.jacoco)
    alias(libs.plugins.roborazzi)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.designsystem.formulaone.core.designsystem"
}

dependencies {
//    lintPublish(projects.lint)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)

    debugApi(libs.androidx.compose.ui.tooling)

    implementation(libs.coil.kt.compose)

//    testImplementation(libs.androidx.compose.ui.test)
//    testImplementation(libs.accompanist.testharness)
//    testImplementation(libs.hilt.android.testing)
//    testImplementation(libs.robolectric)
//    testImplementation(libs.roborazzi)
//    testImplementation(projects.core.testing)

//    androidTestImplementation(libs.androidx.compose.ui.test)
//    androidTestImplementation(projects.core.testing)
}
