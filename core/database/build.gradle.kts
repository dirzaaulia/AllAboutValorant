plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.android.library.jacoco)
    alias(libs.plugins.formulaone.android.hilt)
    alias(libs.plugins.formulaone.android.room)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//            "com.google.samples.apps.formulaone.core.testing.NiaTestRunner"
    }
    namespace = "com.dirzaaulia.formulaone.core.database"
}

dependencies {
    api(projects.core.model)

    implementation(libs.kotlinx.datetime)

//    androidTestImplementation(projects.core.testing)
}
