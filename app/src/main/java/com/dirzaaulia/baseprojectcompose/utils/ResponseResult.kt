package com.dirzaaulia.baseprojectcompose.utils

import com.dirzaaulia.baseprojectcompose.utils.ResponseResult.Error
import com.dirzaaulia.baseprojectcompose.utils.ResponseResult.Success
import retrofit2.HttpException
import retrofit2.Response

/**
 * A generic class that holds a value or an exception
 */
sealed class ResponseResult<out R> {
  data class Success<out T>(val data: T) : ResponseResult<T>()
  data class Error(val throwable: Throwable) : ResponseResult<Nothing>()
  object Loading: ResponseResult<Nothing>()
}

//inline fun <T> executeWithResponse(body: () -> T): ResponseResult<T> {
//  return try {
//    val response = body.invoke()
//    response?.let {
//
//    }
//    Success(body.invoke())
//  } catch (throwable: Throwable) {
//    throwable.printStackTrace()
//    Error(throwable)
//  }
//}

inline fun <T> executeWithResponse(body: () -> Response<T>): ResponseResult<T> {
  return try {
    val response = body.invoke()
    response.body()?.let {
      Success(it)
    } ?: run {
      throw HttpException(response)
    }
  } catch (throwable: Throwable) {
    throwable.printStackTrace()
    Error(throwable)
  }
}