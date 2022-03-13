package com.renclav.samplecalendarbooking.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

internal class BookingSelectionViewModel @AssistedInject constructor(
    @Assisted initialState: BookingSelectionStateModel,
) : MavericksViewModel<BookingSelectionStateModel>(initialState) {

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
                dummy = "cool, I work"
            )
        }
    }
}