package com.renclav.samplecalendarbooking.data

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * This is where API/Service workers and data layer model mappers/loggers live
 */
@InstallIn(SingletonComponent::class)
@Module
internal object BookingSelectionDataModule