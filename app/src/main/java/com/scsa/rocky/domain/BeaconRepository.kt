package com.scsa.rocky.domain

import kotlinx.coroutines.flow.Flow

interface BeaconRepository {
    fun getBeaconInfo(): Flow<Beacon>
    fun startScanning(): Void
    fun stopScanning(): Void

}