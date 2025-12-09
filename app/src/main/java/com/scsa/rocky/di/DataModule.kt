package com.scsa.rocky.di

import com.scsa.rocky.data.FakeBeaconRepositoryImpl
import com.scsa.rocky.domain.BeaconRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideBeaconRepository(): BeaconRepository {
        return FakeBeaconRepositoryImpl()
    }
}