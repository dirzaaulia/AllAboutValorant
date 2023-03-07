package com.dirzaaulia.baseprojectcompose.repository

import androidx.annotation.WorkerThread
import com.dirzaaulia.baseprojectcompose.network.Service
import com.dirzaaulia.baseprojectcompose.utils.ResponseResult
import com.dirzaaulia.baseprojectcompose.utils.executeWithResponse
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