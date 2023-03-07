package com.dirzaaulia.baseprojectcompose.di

import com.dirzaaulia.baseprojectcompose.network.Service
import com.dirzaaulia.baseprojectcompose.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(service: Service): Repository {
        return Repository(service)
    }
}