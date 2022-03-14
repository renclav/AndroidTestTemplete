package com.renclav.samplecalendarbooking.presentation

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.renclav.samplecalendarbooking.domain.model.Booking
import com.renclav.samplecalendarbooking.domain.model.SpaceDetails
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

internal data class BookingSelectionStateModel(
    val currentBookings: Async<List<Booking>>,
    val currentSpace: SpaceDetails,
) : MavericksState {

    private companion object {
        val dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss z")
    }

    val formattedBookings = currentBookings()
        ?.map {
            DynamicBooking(
                start = it.start.format(dateFormatter),
                end = it.end.format(dateFormatter),
                spaceDetails = it.spaceDetails,
            )
        }
        .orEmpty()


    internal data class DynamicBooking(
        val start: String,
        val end: String,
        val spaceDetails: SpaceDetails,
    )
}