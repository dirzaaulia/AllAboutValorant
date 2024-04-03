plugins {
    alias(libs.plugins.formulaone.android.feature)
    alias(libs.plugins.formulaone.android.library.compose)
    alias(libs.plugins.formulaone.android.library.jacoco)
}

android {
    namespace = "com.dirzaaulia.formulaone.feature.settings"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.google.oss.licenses)
    implementation(projects.core.data)

//    testImplementation(projects.core.testing)

//    androidTestImplementation(projects.core.testing)
}
