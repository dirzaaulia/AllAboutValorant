package com.dirzaaulia.baseprojectcompose.data.model

import androidx.annotation.Keep
import com.dirzaaulia.baseprojectcompose.utils.Constant
import com.squareup.moshi.Json

@Keep
data class LatestPhones(

    @Json(name = "title")
    val title: String = Constant.EMPTY_STRING,

    @Json(name = "phones")
    val phones: List<Phone> = emptyList()
)