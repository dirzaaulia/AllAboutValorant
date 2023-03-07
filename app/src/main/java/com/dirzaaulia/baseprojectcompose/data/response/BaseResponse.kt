package com.dirzaaulia.baseprojectcompose.data.response

import com.dirzaaulia.baseprojectcompose.data.model.LatestPhones
import com.squareup.moshi.Json

data class LatestPhonesResponse (

    @Json(name = "status")
    val status: Boolean = false,

    @Json(name = "data")
    val data: LatestPhones? = null
)