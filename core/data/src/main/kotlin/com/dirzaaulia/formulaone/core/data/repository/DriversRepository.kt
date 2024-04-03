package com.dirzaaulia.formulaone.core.data.repository

import com.dirzaaulia.formulaone.core.data.model.Driver
import kotlinx.coroutines.flow.Flow

interface DriversRepository {

    fun getDrivers(): Flow<List<Driver>>
}