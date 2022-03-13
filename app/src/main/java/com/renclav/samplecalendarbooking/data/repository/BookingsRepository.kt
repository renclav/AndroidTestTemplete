package com.renclav.samplecalendarbooking.data.repository

import com.renclav.samplecalendarbooking.data.model.BookingsByUserResult
import com.renclav.samplecalendarbooking.data.model.ExistingBooking
import com.renclav.samplecalendarbooking.util.coroutines.AppCoroutineDispatchers
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Performs CRUD for all booking related information
 * Since this is a test, its hardcoded (with no api, mappers, etc)
 * NOTE: this is not and interface as its not needed for testing eg
 * to make a fake of this, we would mock the constructor args, and not the logic here in common cases
 */
internal class BookingsRepository @Inject constructor(
    private val dispatchers: AppCoroutineDispatchers,
    private val moshi: Moshi,
) {
    private val fakeBookingData = """
    [
  {
    "starts_at": "2022-03-10T09:00:00.000Z",
    "ends_at": "2022-03-10T17:00:00.000Z",
    "space_name": "Work.Life Reading",
    "space_timezone": "Europe/London",
    "space_image": "https://img.desana.io/7ansazJHWcMX9q82O1NbE1wiLy7C8VCivOd0guAh3Q8/rs:fill/w:447/h:300/g:ce/el:true/Z3M6Ly91c2VyLWltYWdlcy5kZXNhbmEuaW8vcy1iYzgzNzFlMC1mODBjLTRkYWUtODQ4MC1hYjViZTViZGZmN2M"
  },
  {
    "starts_at": "2022-03-22T09:00:00.000Z",
    "ends_at": "2022-03-22T17:00:00.000Z",
    "space_name": "The Melting Pot",
    "space_timezone": "Europe/London",
    "space_image": "https://img.desana.io/cWjmibPOjHx6YXosDpFNsWfm08AhcTlSkEbjE90l2oQ/rs:fill/w:431/h:300/g:ce/el:true/Z3M6Ly91c2VyLWltYWdlcy5kZXNhbmEuaW8vcy03NTdhOWU0Ny04OWIyLTQ4NTEtOWUxNy01Y2Q2MTg4OGJjY2M"
  },
  {
    "starts_at": "2022-03-23T13:00:00.000Z",
    "ends_at": "2022-03-23T17:00:00.000Z",
    "space_name": "The Melting Pot",
    "space_timezone": "Europe/London",
    "space_image": "https://img.desana.io/cWjmibPOjHx6YXosDpFNsWfm08AhcTlSkEbjE90l2oQ/rs:fill/w:431/h:300/g:ce/el:true/Z3M6Ly91c2VyLWltYWdlcy5kZXNhbmEuaW8vcy03NTdhOWU0Ny04OWIyLTQ4NTEtOWUxNy01Y2Q2MTg4OGJjY2M"
  },
  {
    "starts_at": "2022-03-28T13:00:00.000Z",
    "ends_at": "2022-03-28T21:00:00.000Z",
    "space_name": "Studio by Tishman Speyer CitySpire",
    "space_timezone": "America/New_York",
    "space_image": "https://img.desana.io/E-7NVTxOTnqUFA9o_AjuNsSWRRlR5lQArOSwkz79IX4/rs:fill/w:431/h:300/g:ce/el:true/Z3M6Ly91c2VyLWltYWdlcy5kZXNhbmEuaW8vcy1kY2I0OTYwMy0zZGU2LTRhYjUtYjliZi0yNTNiMTlmNzZhYzk"
  }
]
    """


    /**
     * Fetch user bookings
     * NOTE: fetching and decoding this data is usually handled by a tool like Retrofit,
     * also, a LCE (loading content error) class would usually be used (or sealed class), this is for
     * expedition
     */
    @OptIn(ExperimentalStdlibApi::class)
    suspend fun getBookingsByUserId(userId: String): Result<BookingsByUserResult> =
        withContext(dispatchers.io) {
            val adapter = moshi.adapter<List<ExistingBooking>>()
            return@withContext Result
                .runCatching {
                    val data =
                        adapter.fromJson(fakeBookingData)
                            ?: throw IllegalStateException("data is null")
                    BookingsByUserResult(
                        data = data,
                    )
                }
        }
}