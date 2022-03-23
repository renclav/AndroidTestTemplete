package com.renclav.samplecalendarbooking.data.repository.source.remote

import com.renclav.samplecalendarbooking.data.model.ResultClass
import retrofit2.http.GET
import retrofit2.http.Query

internal interface  DummyAPI {
    @GET("path")
    suspend fun getThing(
        @Query("data") data: String,
    ) : ResultClass
}