plugins {
    alias(libs.plugins.formulaone.android.feature)
    alias(libs.plugins.formulaone.android.library.compose)
    alias(libs.plugins.formulaone.android.library.jacoco)
    alias(libs.plugins.roborazzi)
}

android {
    namespace = "com.dirzaaulia.formulaone.feature.home"
}

dependencies {
    implementation(libs.accompanist.permissions)
    implementation(projects.core.data)
//    implementation(projects.core.domain)

    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.robolectric)
//    testImplementation(projects.core.testing)
    testDemoImplementation(libs.roborazzi)

//    androidTestImplementation(projects.core.testing)
}
