import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.dirzaaulia.formulaone.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
    compileOnly(libs.firebase.performance.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
    implementation(libs.truth)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "formulaone.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "formulaone.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidFirebase") {
            id = "formulaone.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("androidFlavors") {
            id = "formulaone.android.application.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = "formulaone.android.application.jacoco"
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
        register("androidFeature") {
            id = "formulaone.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "formulaone.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "formulaone.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "formulaone.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryJacoco") {
            id = "formulaone.android.library.jacoco"
            implementationClass = "AndroidLibraryJacocoConventionPlugin"
        }
        register("androidLint") {
            id = "formulaone.android.lint"
            implementationClass = "AndroidLintConventionPlugin"
        }
        register("androidRoom") {
            id = "formulaone.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidTest") {
            id = "formulaone.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("jvmLibrary") {
            id = "formulaone.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
