package com.renclav.samplecalendarbooking.domain

import com.renclav.samplecalendarbooking.domain.mapper.BookingSelectionCurrentBookingsResponseMapper
import com.renclav.samplecalendarbooking.domain.mapper.BookingSelectionCurrentBookingsResponseMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
internal interface BookingSelectionDomainModule {
    @Binds
    fun BookingSelectionCurrentBookingsResponseMapperImpl.bindCurrentBookingsResponseMapper(): BookingSelectionCurrentBookingsResponseMapper
}