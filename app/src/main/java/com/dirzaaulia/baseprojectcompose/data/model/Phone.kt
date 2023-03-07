package com.dirzaaulia.baseprojectcompose.data.model

import androidx.annotation.Keep
import com.dirzaaulia.baseprojectcompose.utils.Constant
import com.squareup.moshi.Json

@Keep
data class Phone(

    @Json(name = "phone_name")
    val phoneName: String = Constant.EMPTY_STRING,

    @Json(name = "slug")
    val slug: String = Constant.EMPTY_STRING,

    @Json(name = "image")
    val image: String = Constant.EMPTY_STRING,

    @Json(name = "detail")
    val detail: String = Constant.EMPTY_STRING
)