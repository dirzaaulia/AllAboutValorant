package com.dirzaaulia.smartphonespec.repository

import androidx.annotation.WorkerThread
import com.dirzaaulia.smartphonespec.network.Service
import com.dirzaaulia.smartphonespec.utils.ResponseResult
import com.dirzaaulia.smartphonespec.utils.executeWithResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(
    private val service: Service
) {

    @WorkerThread
    fun getLatestPhones() = flow {
        emit(ResponseResult.Loading)
        emit(executeWithResponse { service.getLatestPhones() })
    }.flowOn(Dispatchers.IO)
}