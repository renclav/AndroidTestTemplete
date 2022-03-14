package com.renclav.samplecalendarbooking.presentation

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.airbnb.mvrx.compose.collectAsState

@Composable
internal fun AvailabilityContent(
    modifier: Modifier,
    viewModel: BookingSelectionViewModel,
/*    currentSpace: SpaceDetails,
    currentBookings: List<Booking>,*/
) {
    Surface(
        modifier = modifier
            .padding(PaddingValues(8.dp)),
        color = MaterialTheme.colors.background
    ) {
        val state by viewModel.collectAsState()
        val currentBookings = state.formattedBookings

        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Current bookings for: ${state.currentSpace.locationName}",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.size(8.dp))
            if (currentBookings.isEmpty()) {
                Text("No bookings? Come on now, lets get to it :)")
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(currentBookings, key = { it.hashCode() }) {
                        CurrentBookingCard(it)
                    }
                }
            }
        }
    }
}

@Composable
internal fun CurrentBookingCard(booking: BookingSelectionStateModel.DynamicBooking) {
    Row(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium),
        verticalAlignment = Alignment.Top,
    ) {
        val painter = rememberImagePainter(
            data = booking.spaceDetails.locationImageUrl,
            builder = {
                /**
                 * Fast solution, better images would be great here
                 */
                placeholder(ColorDrawable(android.graphics.Color.GRAY))
                error(ColorDrawable(android.graphics.Color.RED))
            },
        )
        Image(
            painter = painter,
            contentDescription = "${booking.spaceDetails.locationName} image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(0.25f)
                .aspectRatio(1f)
                .clip(MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = booking.spaceDetails.locationName,
                style = MaterialTheme.typography.subtitle2,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "Start: " + booking.start,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "End: " + booking.start,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}