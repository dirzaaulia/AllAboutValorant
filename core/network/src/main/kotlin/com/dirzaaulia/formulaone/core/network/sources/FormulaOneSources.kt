package com.dirzaaulia.formulaone.core.network.sources

import com.dirzaaulia.formulaone.core.network.model.NetworkDriver

interface FormulaOneSources {

    suspend fun getDrivers(): List<NetworkDriver>

}