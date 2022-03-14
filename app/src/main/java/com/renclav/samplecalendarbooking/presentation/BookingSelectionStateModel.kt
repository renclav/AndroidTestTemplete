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
    val selectedDay: ZonedDateTime?,
) : MavericksState {

    private companion object {
        val dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm sZ")
        val selectedDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    }

    val toolBarTitle = if (selectedDay == null) {
        "Select a Date"
    } else {
        "Selected: ${selectedDay.format(selectedDateFormatter)}"
    }

    val formattedBookings = currentBookings()
        ?.map {
            DynamicBooking(
                start = if (selectedDay != null) {
                    it.start.withZoneSameInstant(selectedDay.zone)
                } else {
                    it.start
                }
                    .format(dateFormatter),
                end = if (selectedDay != null) {
                    it.end.withZoneSameInstant(selectedDay.zone)
                } else {
                    it.end
                }
                    .format(dateFormatter),
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