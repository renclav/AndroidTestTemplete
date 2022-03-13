package com.renclav.samplecalendarbooking.data.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

internal data class BookingsByUserResult(
    val data : List<ExistingBooking>,
)

@Keep
@JsonClass(generateAdapter = true)
internal data class ExistingBooking(
    @Json(name = "ends_at")
    val endsAt: String? = null,
    @Json(name = "space_image")
    val spaceImage: String? = null,
    @Json(name = "space_name")
    val spaceName: String? = null,
    @Json(name = "space_timezone")
    val spaceTimezone: String? = null,
    @Json(name = "starts_at")
    val startsAt: String? = null
)