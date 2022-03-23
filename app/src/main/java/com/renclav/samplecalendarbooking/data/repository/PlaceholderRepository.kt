package com.renclav.samplecalendarbooking.data.repository

import com.renclav.samplecalendarbooking.data.model.ResultClass
import com.renclav.samplecalendarbooking.data.repository.source.remote.DummyAPI
import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import com.squareup.moshi.Moshi
import kotlinx.coroutines.withContext
import javax.inject.Inject


internal class PlaceholderRepository @Inject constructor(
    private val dispatchers: AppCoroutineDispatchers,
    private val client: DummyAPI,
) {

    suspend fun getDummyThing(thing: String): ResultClass =
        withContext(dispatchers.io) {
            return@withContext client
                .getThing(thing)
        }

}