plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.android.library.jacoco)
    alias(libs.plugins.formulaone.android.hilt)
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.dirzaaulia.formulaone.core.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    api(libs.kotlinx.datetime)
    api(projects.core.common)
    api(projects.core.model)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)
    implementation(libs.okhttp.logging)
    implementation(libs.chuckerDebug)
    implementation(libs.bundles.ktor)

    releaseImplementation(libs.chuckerRelease)

//    testImplementation(libs.kotlinx.coroutines.test)
}
