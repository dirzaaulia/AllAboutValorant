package com.dirzaaulia.core.common.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val formulaOneDispatchers: FormulaOneDispatchers)

enum class FormulaOneDispatchers {
    Default,
    IO,
}
