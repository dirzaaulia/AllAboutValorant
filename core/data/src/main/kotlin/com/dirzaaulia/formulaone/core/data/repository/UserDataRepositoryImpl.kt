package com.dirzaaulia.formulaone.core.data.repository

import UserData
import com.dirzaaulia.formulaone.core.datastore.FormulaOnePreferencesDataSource
import com.dirzaaulia.formulaone.core.model.data.DarkThemeConfig
import com.dirzaaulia.formulaone.core.model.data.ThemeBrand
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class UserDataRepositoryImpl @Inject constructor(
    private val formulaOnePreferencesDataSource: FormulaOnePreferencesDataSource,
//    private val analyticsHelper: AnalyticsHelper,
) : UserDataRepository {

    override val userData: Flow<UserData> =
        formulaOnePreferencesDataSource.userData

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        formulaOnePreferencesDataSource.setThemeBrand(themeBrand)
    }

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        formulaOnePreferencesDataSource.setDarkThemeConfig(darkThemeConfig)
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        formulaOnePreferencesDataSource.setDynamicColorPreference(useDynamicColor)
    }

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        formulaOnePreferencesDataSource.setShouldHideOnboarding(shouldHideOnboarding)
    }
}
