package com.renclav.samplecalendarbooking.presentation

/*@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun CalenderContent(
    modifier: Modifier,
    viewModel: DummyFeatureViewModel,
    dateSelected: ((ZonedDateTime) -> Unit),
) {
    val _currentBookings by viewModel.collectAsState(DummyFeatureStateModel::currentBookings)
    val currentSpace by viewModel.collectAsState(DummyFeatureStateModel::currentSpace)
    val currentBookings = _currentBookings().orEmpty()

    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        *//**
         * Hardcoded month of March
         *//*

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "March 2022",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            //Hard coded, based on tech spec, that we're selecting from Bristol, United Kingdom
            val startOfMarch = ZonedDateTime.of(2022, 3, 1, 0, 0, 0, 0, currentSpace.zoneId)
            LazyVerticalGrid(cells = GridCells.Fixed(7), contentPadding = PaddingValues(8.dp)) {
                items(31) {
                    val currentDay = startOfMarch.plusDays(it.toLong())
                    Day(day = (it + 1), currentBookings, currentDay) {
                        dateSelected(currentDay)
                    }
                }
            }
        }
    }
}*/

/**
 * Start of March timestamp, should really be pulled out (far too tired)
 */
/*
@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun Day(
    day: Int,
    currentBookings: List<Booking>,
    currentDay: ZonedDateTime,
    onClick: (() -> Unit)
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        shape = MaterialTheme.shapes.small,
        onClick = onClick,
    ) {
        val containsBooking = currentBookings.filter {
            it.start.truncatedTo(ChronoUnit.DAYS).equals(currentDay.truncatedTo(ChronoUnit.DAYS))
        }

        if (containsBooking.isEmpty()) {
            Text(
                modifier = Modifier.wrapContentSize(Alignment.Center),
                text = day.toString(),
                style = MaterialTheme.typography.caption
            )
        } else {
            BadgedBox(
                modifier = Modifier.padding(16.dp),
                badge = {
                    Badge { Text(containsBooking.size.toString()) }
                }
            ) {
                Text(
                    modifier = Modifier.wrapContentSize(Alignment.Center),
                    text = day.toString(),
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}*/
