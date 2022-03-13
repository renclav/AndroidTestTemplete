package com.renclav.samplecalendarbooking.presentation

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
internal interface BookingSelectionViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(BookingSelectionViewModel::class)
    fun BookingSelectionViewModel.Factory.bindBookingSelectionFactory(): AssistedViewModelFactory<*, *>

}