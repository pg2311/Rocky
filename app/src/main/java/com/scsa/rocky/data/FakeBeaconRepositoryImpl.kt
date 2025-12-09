package com.scsa.rocky.data

import com.scsa.rocky.domain.Beacon
import com.scsa.rocky.domain.BeaconRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class FakeBeaconRepositoryImpl : BeaconRepository{
    override fun getBeaconInfo(): Flow<Beacon> = flow {
        while (true) {
            val randomRssi = -70.0 + Random.nextDouble(20.0)
            emit(
                Beacon(
                    uuid="FakeBeaconUUID",
                    rssi=randomRssi
                )
            )
            delay(500)
        }
    }
    override fun startScanning(): Void {
        TODO("Not yet implemented")
    }

    override fun stopScanning(): Void {
        TODO("Not yet implemented")
    }
}