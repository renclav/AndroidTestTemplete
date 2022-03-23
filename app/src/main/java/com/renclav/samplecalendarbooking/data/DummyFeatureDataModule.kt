package com.renclav.samplecalendarbooking.data

import com.renclav.samplecalendarbooking.data.repository.source.remote.DummyAPI
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
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

    @Provides
    @Reusable
    fun dummyRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            )
            .build()
    }

    @Provides
    @Reusable
    fun dummyClient(retrofit: Retrofit): DummyAPI {
        return retrofit.create()
    }
}