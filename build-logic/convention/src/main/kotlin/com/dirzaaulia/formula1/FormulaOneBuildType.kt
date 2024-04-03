package com.dirzaaulia.formula1

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class FormulaOneBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}
