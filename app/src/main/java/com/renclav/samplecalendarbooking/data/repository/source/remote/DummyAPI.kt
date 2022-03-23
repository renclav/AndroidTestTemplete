package com.renclav.samplecalendarbooking.data.repository.source.remote

import com.renclav.samplecalendarbooking.data.model.ResultClass

internal interface  DummyAPI {
    suspend fun getThing(
        data: String,
    ) : ResultClass
}