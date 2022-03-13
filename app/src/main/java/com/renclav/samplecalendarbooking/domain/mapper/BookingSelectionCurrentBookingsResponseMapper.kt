package com.renclav.samplecalendarbooking.domain.mapper

import com.renclav.samplecalendarbooking.data.model.BookingsByUserResult
import com.renclav.samplecalendarbooking.domain.model.Booking
import com.renclav.samplecalendarbooking.domain.model.SpaceDetails
import java.time.Instant
import java.time.ZoneId
import javax.inject.Inject

/**
 * Map data layer bookings to domain layer for use by the viewmodel
 */
internal interface BookingSelectionCurrentBookingsResponseMapper {
    operator fun invoke(
        data: BookingsByUserResult?
    ): List<Booking>
}

internal class BookingSelectionCurrentBookingsResponseMapperImpl @Inject constructor(
) : BookingSelectionCurrentBookingsResponseMapper {
    override fun invoke(data: BookingsByUserResult?): List<Booking> {
        return requireNotNull(data) {
            "current bookings by user required"
        }
            .data
            .mapNotNull {
                val start = it.startsAt?.let { start ->
                    Instant.parse(start)
                }
                val end = it.endsAt?.let { end ->
                    Instant.parse(end)
                }
                val zoneId = it.spaceTimezone?.let { zone ->
                    ZoneId.of(zone)
                }
                if (start == null || end == null || zoneId == null) {
                    null
                } else {
                    Booking(
                        start = start.atZone(zoneId),
                        end = end.atZone(zoneId),
                        spaceDetails = SpaceDetails(
                            locationName = it.spaceName.orEmpty(),
                            locationImageUrl = it.spaceImage.orEmpty(),
                        ),
                    )
                }
            }
    }

}