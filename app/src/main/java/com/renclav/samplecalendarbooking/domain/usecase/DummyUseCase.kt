package com.renclav.samplecalendarbooking.domain.usecase

import com.renclav.samplecalendarbooking.data.repository.PlaceholderRepository
import com.renclav.samplecalendarbooking.domain.mapper.DummyResponseMapper
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
internal interface DummyUseCase {
    operator fun invoke(userId: String): Flow<List<String>>
}

internal class DummyUseCaseImpl @Inject constructor(
    private val dispatchers: AppCoroutineDispatchers,
    private val placeholderRepository: PlaceholderRepository,
    private val currentBookingsResponseMapper: DummyResponseMapper,
) : DummyUseCase {
    override fun invoke(userId: String): Flow<List<String>> {
        return flow {
            val response = placeholderRepository
                .getDummyThing(userId)
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
