package com.dirzaaulia.formulaone.core.network

import com.dirzaaulia.formulaone.core.network.sources.FormulaOneSourceImpl
import com.dirzaaulia.formulaone.core.network.sources.FormulaOneSources
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Interface representing network calls to the NIA backend
 */
@Module
@InstallIn(SingletonComponent::class)
internal interface FormulaOneNetworkDataSource {
    @Binds
    fun bindsFormulaOneSources(
        formulaOneSourceImpl: FormulaOneSourceImpl,
    ): FormulaOneSources
}
