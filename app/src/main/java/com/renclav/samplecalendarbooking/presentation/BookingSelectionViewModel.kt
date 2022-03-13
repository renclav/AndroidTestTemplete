package com.renclav.samplecalendarbooking.presentation

import com.airbnb.mvrx.*
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.renclav.samplecalendarbooking.domain.usecase.BookingSelectionCurrentBookingsUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

internal class BookingSelectionViewModel @AssistedInject constructor(
    @Assisted initialState: BookingSelectionStateModel,
    currentBookingsUseCase: BookingSelectionCurrentBookingsUseCase,
) : MavericksViewModel<BookingSelectionStateModel>(initialState) {

    init {
        currentBookingsUseCase("dummy id we would get from fragment arguments")
            .execute {
                copy(
                    currentBookings = it
                )
            }
    }

    @AssistedFactory
    interface Factory :
        AssistedViewModelFactory<BookingSelectionViewModel, BookingSelectionStateModel> {
        override fun create(state: BookingSelectionStateModel): BookingSelectionViewModel
    }

    companion object :
        MavericksViewModelFactory<BookingSelectionViewModel, BookingSelectionStateModel>
        by hiltMavericksViewModelFactory() {

        override fun initialState(viewModelContext: ViewModelContext): BookingSelectionStateModel {
            return BookingSelectionStateModel(
                currentBookings = Uninitialized,
            )
        }
    }
}