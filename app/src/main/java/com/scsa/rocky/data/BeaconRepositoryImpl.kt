package com.scsa.rocky.data

import com.scsa.rocky.domain.Beacon
import com.scsa.rocky.domain.BeaconRepository
import kotlinx.coroutines.flow.Flow

class BeaconRepositoryImpl : BeaconRepository{
    override fun getBeaconInfo(): Flow<Beacon> {
        TODO("Not yet implemented")
    }

    override fun startScanning(): Void {
        TODO("Not yet implemented")
    }

    override fun stopScanning(): Void {
        TODO("Not yet implemented")
    }
}