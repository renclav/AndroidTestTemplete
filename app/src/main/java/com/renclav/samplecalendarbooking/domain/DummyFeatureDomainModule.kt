package com.renclav.samplecalendarbooking.domain

import com.renclav.samplecalendarbooking.domain.mapper.DummyResponseMapper
import com.renclav.samplecalendarbooking.domain.mapper.DummyResponseMapperImpl
import com.renclav.samplecalendarbooking.domain.usecase.DummyUseCase
import com.renclav.samplecalendarbooking.domain.usecase.DummyUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
internal interface DummyFeatureDomainModule {
    @Binds
    fun DummyResponseMapperImpl.bindCurrentBookingsResponseMapper(): DummyResponseMapper

    @Binds
    fun DummyUseCaseImpl.bindCurrentBookingsUseCase(): DummyUseCase

}