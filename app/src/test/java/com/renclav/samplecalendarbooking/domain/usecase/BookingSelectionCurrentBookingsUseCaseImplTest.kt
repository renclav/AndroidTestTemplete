package com.renclav.samplecalendarbooking.domain.usecase

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.renclav.samplecalendarbooking.MainCoroutineScopeRule
import com.renclav.samplecalendarbooking.data.model.BookingsByUserResult
import com.renclav.samplecalendarbooking.data.model.ExistingBooking
import com.renclav.samplecalendarbooking.data.repository.BookingsRepository
import com.renclav.samplecalendarbooking.domain.mapper.BookingSelectionCurrentBookingsResponseMapperImpl
import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

@OptIn(ExperimentalCoroutinesApi::class)
class BookingSelectionCurrentBookingsUseCaseImplTest {

    @get:Rule
    val coroutineRule = MainCoroutineScopeRule()

    private companion object {
        const val USER_ID = "id"
    }

    private lateinit var bookingSelectionCurrentBookingsUseCase: BookingSelectionCurrentBookingsUseCase
    private val bookingsRepository = mock<BookingsRepository>()
    private val currentBookingsResponseMapper = BookingSelectionCurrentBookingsResponseMapperImpl()

    @Before
    fun setUp() {
        bookingSelectionCurrentBookingsUseCase = BookingSelectionCurrentBookingsUseCaseImpl(
            dispatchers = AppCoroutineDispatchers(coroutineRule.dispatcher),
            bookingsRepository = bookingsRepository,
            currentBookingsResponseMapper = currentBookingsResponseMapper,
        )
    }

    @Test
    fun `Flow completes without error`() = coroutineRule.runBlockingTest {
        val repoResult = successRepoResult()

        bookingsRepository
            .stub {
                onBlocking {
                    getBookingsByUserId(ArgumentMatchers.anyString())
                }.doReturn(Result.success(repoResult))
            }

        bookingSelectionCurrentBookingsUseCase(USER_ID)
            .test {
                val result = awaitItem()
                assertThat(result.size).isEqualTo(repoResult.data.size)
                awaitComplete()
            }
    }

    /**
     * Additional tests to check error states of null, empty and exception handling required
     */

    /**
     * Could be cleaner with a standalone 'fake' of the repo providing these fake results
     */
    private fun successRepoResult() =
        BookingsByUserResult(
            listOf(
                ExistingBooking(
                    endsAt = "2022-03-28T21:00:00.000Z",
                    startsAt = "2022-03-28T13:00:00.000Z",
                    spaceImage = "https://img.desana.io/E-7NVTxOTnqUFA9o_AjuNsSWRRlR5lQArOSwkz79IX4/rs:fill/w:431/h:300/g:ce/el:true/Z3M6Ly91c2VyLWltYWdlcy5kZXNhbmEuaW8vcy1kY2I0OTYwMy0zZGU2LTRhYjUtYjliZi0yNTNiMTlmNzZhYzk",
                    spaceName = "Studio by Tishman Speyer CitySpire",
                    spaceTimezone = "America/New_York",
                )
            ),
        )
}