plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.android.library.jacoco)
    alias(libs.plugins.formulaone.android.hilt)
}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.dirzaaulia.formulaone.core.datastore"
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    api(libs.androidx.dataStore.core)
    api(projects.core.datastoreProto)
    api(projects.core.model)

    implementation(projects.core.common)

//    testImplementation(projects.core.datastoreTest)
//    testImplementation(libs.kotlinx.coroutines.test)
}
