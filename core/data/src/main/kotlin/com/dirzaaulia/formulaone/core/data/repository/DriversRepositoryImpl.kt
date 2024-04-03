package com.dirzaaulia.formulaone.core.data.repository

import com.dirzaaulia.core.common.network.Dispatcher
import com.dirzaaulia.core.common.network.FormulaOneDispatchers
import com.dirzaaulia.formulaone.core.data.model.Driver
import com.dirzaaulia.formulaone.core.data.model.toDriver
import com.dirzaaulia.formulaone.core.network.sources.FormulaOneSources
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DriversRepositoryImpl @Inject constructor(
    @Dispatcher(FormulaOneDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val network: FormulaOneSources
): DriversRepository {
    override fun getDrivers(): Flow<List<Driver>> = flow {
        emit(network.getDrivers().map { it.toDriver() })
    }.flowOn(ioDispatcher)
}