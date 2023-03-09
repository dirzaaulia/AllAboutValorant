package com.dirzaaulia.smartphonespec.data.response

import com.dirzaaulia.smartphonespec.data.model.LatestPhones
import com.squareup.moshi.Json

data class LatestPhonesResponse (

    @Json(name = "status")
    val status: Boolean = false,

    @Json(name = "data")
    val data: LatestPhones? = null
)