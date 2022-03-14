package com.renclav.samplecalendarbooking.domain.usecase

import com.renclav.samplecalendarbooking.data.repository.BookingsRepository
import com.renclav.samplecalendarbooking.domain.mapper.BookingSelectionCurrentBookingsResponseMapper
import com.renclav.samplecalendarbooking.domain.model.Booking
import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber
import javax.inject.Inject

/**
 * Fetches current bookings linked to a userId
 * Note: this uses a Flow as real world app might observe this for changes,
 * instead of a being a one-off for this demo
 */
internal interface BookingSelectionCurrentBookingsUseCase {
    operator fun invoke(userId: String): Flow<List<Booking>>
}

internal class BookingSelectionCurrentBookingsUseCaseImpl @Inject constructor(
    private val dispatchers: AppCoroutineDispatchers,
    private val bookingsRepository : BookingsRepository,
    private val currentBookingsResponseMapper: BookingSelectionCurrentBookingsResponseMapper,
) : BookingSelectionCurrentBookingsUseCase {
    override fun invoke(userId: String): Flow<List<Booking>> {
        return flow {
            val response = bookingsRepository
                .getBookingsByUserId(userId)
                .getOrThrow()
                .let {
                    currentBookingsResponseMapper(it)
                }
            emit(response)
        }
            .catch {
                //Log exception and re-throw
                Timber.e(it)
                throw it
            }
            .flowOn(dispatchers.computation)
    }
}
