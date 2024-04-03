package com.dirzaaulia.formulaone.core.data.di

import com.dirzaaulia.formulaone.core.data.repository.DriversRepository
import com.dirzaaulia.formulaone.core.data.repository.DriversRepositoryImpl
import com.dirzaaulia.formulaone.core.data.repository.UserDataRepository
import com.dirzaaulia.formulaone.core.data.repository.UserDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface FormulaOneRepositoryModule {
    @Binds
    fun bindsDriversRepository(
        driversRepositoryImpl: DriversRepositoryImpl,
    ): DriversRepository

    @Binds
    fun bindsUserDataRepository(
        userDataRepositoryImpl: UserDataRepositoryImpl
    ): UserDataRepository
}
