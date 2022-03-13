package com.renclav.samplecalendarbooking.data.repository

import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Performs CRUD for all booking related information
 * Since this is a test, its hardcoded
 * NOTE: this is not and interface as its not needed for testing eg
 * to make a fake of this, we would mock the constructor args, and not the logic here in common cases
 */
internal class BookingsRepository @Inject constructor(
    private val dispatchers: AppCoroutineDispatchers,
) {
    suspend fun getBookingsByUserId(userId: String) = withContext(dispatchers.io) {
        Result.
        TODO("Add fake data from json")
    }
}