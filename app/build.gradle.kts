import com.dirzaaulia.formula1.FormulaOneBuildType

plugins {
    alias(libs.plugins.formulaone.android.application)
    alias(libs.plugins.formulaone.android.application.compose)
    alias(libs.plugins.formulaone.android.application.flavors)
    alias(libs.plugins.formulaone.android.application.jacoco)
    alias(libs.plugins.formulaone.android.hilt)
    id("jacoco")
    alias(libs.plugins.formulaone.android.application.firebase)
    id("com.google.android.gms.oss-licenses-plugin")
    alias(libs.plugins.baselineprofile)
    alias(libs.plugins.roborazzi)
    alias(libs.plugins.kotlinAndroid)
}

android {
    defaultConfig {
        applicationId = "com.dirzaaulia.formulaone"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        // Custom test runner to set up Hilt dependency graph
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = FormulaOneBuildType.DEBUG.applicationIdSuffix
        }
        val release = getByName("release") {
            isMinifyEnabled = true
            applicationIdSuffix = FormulaOneBuildType.RELEASE.applicationIdSuffix
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
            // Ensure Baseline Profile is fresh for release builds.
            baselineProfile.automaticGenerationDuringBuild = true
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    namespace = "com.dirzaaulia.formulaone"
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.settings)

    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.data)
    implementation(projects.core.model)
//    implementation(projects.core.analytics)
//    implementation(projects.sync.work)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.compose.runtime.tracing)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.coil.kt)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

//    debugImplementation(libs.androidx.compose.ui.testManifest)
//    debugImplementation(projects.uiTestHiltManifest)

    kspTest(libs.hilt.compiler)

//    testImplementation(projects.core.dataTest)
//    testImplementation(projects.core.testing)
//    testImplementation(libs.accompanist.testharness)
//    testImplementation(libs.hilt.android.testing)
//    testImplementation(libs.work.testing)

//    testDemoImplementation(libs.robolectric)
//    testDemoImplementation(libs.roborazzi)

//    androidTestImplementation(projects.core.testing)
//    androidTestImplementation(projects.core.dataTest)
//    androidTestImplementation(projects.core.datastoreTest)
//    androidTestImplementation(libs.androidx.navigation.testing)
//    androidTestImplementation(libs.accompanist.testharness)
//    androidTestImplementation(libs.hilt.android.testing)

//    baselineProfile(projects.benchmarks)
}

baselineProfile {
    // Don't build on every iteration of a full assemble.
    // Instead enable generation directly for the release build variant.
    automaticGenerationDuringBuild = false
}

dependencyGuard {
    configuration("prodReleaseRuntimeClasspath")
}
