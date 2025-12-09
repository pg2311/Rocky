package com.scsa.rocky.ui

import com.scsa.rocky.domain.Beacon

data class MainUiState (
    val beacons: List<Beacon> = emptyList(),
    val beaconDistance: Double? = null,
    val isScanning: Boolean = false,
    val errorMessage: String? = null
)