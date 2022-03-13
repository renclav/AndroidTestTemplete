package com.renclav.samplecalendarbooking.domain.model

import java.time.ZonedDateTime

internal data class Booking(
    val start: ZonedDateTime,
    val end: ZonedDateTime,
    val locationName: String,
    val locationImageUrl: String,
)