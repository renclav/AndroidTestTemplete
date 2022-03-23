package com.renclav.samplecalendarbooking.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.renclav.samplecalendarbooking.domain.usecase.DummyUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

internal class DummyFeatureViewModel @AssistedInject constructor(
    @Assisted initialState: DummyFeatureStateModel,
    dummyFeatureUseCase: DummyUseCase,
) : MavericksViewModel<DummyFeatureStateModel>(initialState) {

    init {
        dummyFeatureUseCase("dummy id we would get from fragment arguments")
            .execute {
                copy(
                    dummyData = it
                )
            }
    }


    @AssistedFactory
    interface Factory :
        AssistedViewModelFactory<DummyFeatureViewModel, DummyFeatureStateModel> {
        override fun create(state: DummyFeatureStateModel): DummyFeatureViewModel
    }

    companion object :
        MavericksViewModelFactory<DummyFeatureViewModel, DummyFeatureStateModel>
        by hiltMavericksViewModelFactory() {

        override fun initialState(viewModelContext: ViewModelContext): DummyFeatureStateModel {
            return DummyFeatureStateModel(
                dummyData = Uninitialized,
            )
        }
    }
}