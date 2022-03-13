package com.renclav.samplecalendarbooking.presentation

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.renclav.samplecalendarbooking.domain.model.Booking

internal data class BookingSelectionStateModel(
    val currentBookings : Async<List<Booking>>,
) : MavericksState