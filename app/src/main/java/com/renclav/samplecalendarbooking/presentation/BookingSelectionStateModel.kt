package com.renclav.samplecalendarbooking.presentation

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.renclav.samplecalendarbooking.domain.model.Booking
import com.renclav.samplecalendarbooking.domain.model.SpaceDetails

internal data class BookingSelectionStateModel(
    val currentBookings : Async<List<Booking>>,
    val currentSpace : SpaceDetails,
) : MavericksState