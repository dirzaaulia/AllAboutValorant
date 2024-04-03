package com.dirzaaulia.formulaone.core.network.model

import androidx.annotation.Keep
import com.dirzaaulia.core.common.utils.IntConstant
import com.dirzaaulia.core.common.utils.StringConstant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class NetworkDriver(
    @SerialName("broadcast_name")
    val broadcastName: String = StringConstant.EMPTY,
    @SerialName("country_code")
    val countryCode: String = StringConstant.EMPTY,
    @SerialName("driver_number")
    val driverNumber: Int = IntConstant.ZERO,
    @SerialName("first_name")
    val firstName: String = StringConstant.EMPTY,
    @SerialName("full_name")
    val fullName: String = StringConstant.EMPTY,
    @SerialName("headshot_url")
    val headshotUrl: String? = StringConstant.EMPTY,
    @SerialName("last_name")
    val lastName: String = StringConstant.EMPTY,
    @SerialName("meeting_key")
    val meetingKey: Int  = IntConstant.ZERO,
    @SerialName("name_acronym")
    val nameAcronym: String = StringConstant.EMPTY,
    @SerialName("session_key")
    val sessionKey: Int = IntConstant.ZERO,
    @SerialName("team_colour")
    val teamColour: String = StringConstant.EMPTY,
    @SerialName("team_name")
    val teamName: String = StringConstant.EMPTY
)