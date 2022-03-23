package com.renclav.samplecalendarbooking.presentation


import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState

internal data class DummyFeatureStateModel(
    val dummyData: Async<List<String>>,
) : MavericksState