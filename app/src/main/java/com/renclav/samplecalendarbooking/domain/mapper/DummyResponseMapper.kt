package com.renclav.samplecalendarbooking.domain.mapper

import com.renclav.samplecalendarbooking.data.model.ResultClass
import javax.inject.Inject

/**
 * Map data layer bookings to domain layer for use by the viewmodel
 */
internal interface DummyResponseMapper {
    operator fun invoke(
        data: ResultClass?
    ): List<String>
}

internal class DummyResponseMapperImpl @Inject constructor(
) : DummyResponseMapper {
    override fun invoke(data: ResultClass?): List<String> {
        return listOf()
    }

}