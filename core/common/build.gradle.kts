plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.android.library.jacoco)
    alias(libs.plugins.formulaone.android.hilt)
}

android {
    namespace = "com.dirzaaulia.formulaone.core.common"
}

dependencies {
//    testImplementation(libs.kotlinx.coroutines.test)
//    testImplementation(libs.turbine)
}