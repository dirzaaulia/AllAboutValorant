package com.dirzaaulia.formulaone.core.network.sources

import com.dirzaaulia.core.common.network.Dispatcher
import com.dirzaaulia.core.common.network.FormulaOneDispatchers
import com.dirzaaulia.formulaone.core.network.KtorClient
import com.dirzaaulia.formulaone.core.network.model.NetworkDriver
import com.dirzaaulia.formulaone.core.network.resources.Drivers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FormulaOneSourceImpl @Inject constructor(
    @Dispatcher(FormulaOneDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val ktorClient: KtorClient
): FormulaOneSources {
    override suspend fun getDrivers(): List<NetworkDriver> {
        return withContext(ioDispatcher) {
            ktorClient.get(Drivers())
        }
    }
}