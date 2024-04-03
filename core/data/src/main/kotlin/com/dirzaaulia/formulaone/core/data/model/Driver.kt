package com.dirzaaulia.formulaone.core.data.model

import com.dirzaaulia.formulaone.core.network.model.NetworkDriver

data class Driver(
    val number: Int,
    val fullName: String,
    val team: String,
    val image: String?
)

fun NetworkDriver.toDriver() = Driver(
    number = driverNumber,
    fullName = fullName,
    team = teamName,
    image = headshotUrl
)