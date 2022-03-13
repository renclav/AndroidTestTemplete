package com.renclav.samplecalendarbooking.domain.usecase

import com.renclav.samplecalendarbooking.domain.model.Booking
import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Fetches current bookings linked to a userId
 * Note: this uses a Flow as real world app might observe this for changes,
 * instead of a being a one-off for this demo
 */
internal interface BookingSelectionCurrentBookingsUseCase {
    operator fun invoke (userId : String) : Flow<List<Booking>>
}

internal class BookingSelectionCurrentBookingsUseCaseImpl @Inject constructor(
    private val dispatchers: AppCoroutineDispatchers,
) : BookingSelectionCurrentBookingsUseCase {
    override fun invoke(userId: String): Flow<List<Booking>> {
        return flow {
            listOf<Booking>()
        }
    }
}
