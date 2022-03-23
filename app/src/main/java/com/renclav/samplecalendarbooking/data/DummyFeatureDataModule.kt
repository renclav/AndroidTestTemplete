package com.renclav.samplecalendarbooking.data

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This is where API/Service workers and data layer model mappers/loggers live
 */
@InstallIn(SingletonComponent::class)
@Module
internal object DummyFeatureDataModule {
    @Provides
    @Singleton
    internal fun moshi(): Moshi {
        return Moshi.Builder()
            .build()
    }
}