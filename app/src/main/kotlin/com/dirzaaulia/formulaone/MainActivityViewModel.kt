/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dirzaaulia.formulaone

import UserData
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dirzaaulia.formulaone.core.data.model.Driver
import com.dirzaaulia.formulaone.core.data.repository.DriversRepository
import com.dirzaaulia.formulaone.core.data.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val driversRepository: DriversRepository,
    userDataRepository: UserDataRepository
) : ViewModel() {

    val uiState: StateFlow<MainActivityUiState> = userDataRepository.userData.map {
        MainActivityUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainActivityUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )

    private val _state: MutableStateFlow<List<Driver>> = MutableStateFlow(emptyList())
    val state = _state.asStateFlow()

    fun getDrivers() {
        Log.d("TAG_DIRZA", "getDrivers()")
        viewModelScope.launch {
            driversRepository.getDrivers()
                .collect {
                    Log.d("TAG_DIRZA", it.toString())
                }
        }
    }

}

sealed interface MainActivityUiState {
    data object Loading : MainActivityUiState
    data class Success(val userData: UserData) : MainActivityUiState
}
