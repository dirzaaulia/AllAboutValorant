plugins {
    alias(libs.plugins.formulaone.android.library)
    alias(libs.plugins.formulaone.android.library.jacoco)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.dirzaaulia.formulaone.core.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.javax.inject)

//    testImplementation(projects.core.testing)
}