package com.dirzaaulia.formulaone.core.data.di

import com.dirzaaulia.formulaone.core.data.util.ConnectivityManagerNetworkMonitor
import com.dirzaaulia.formulaone.core.data.util.NetworkMonitor
import com.dirzaaulia.formulaone.core.data.util.TimeZoneBroadcastMonitor
import com.dirzaaulia.formulaone.core.data.util.TimeZoneMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor

    @Binds
    internal abstract fun binds(impl: TimeZoneBroadcastMonitor): TimeZoneMonitor
}
