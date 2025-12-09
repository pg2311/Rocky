package com.scsa.rocky.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scsa.rocky.domain.BeaconRepository
import com.scsa.rocky.domain.CalculateBeaconDistance
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val beaconRepository: BeaconRepository,
    private val calculateBeaconDistance: CalculateBeaconDistance
): ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        observeBeaconData()
    }


    fun onStartScan() {
        _uiState.update { it.copy(isScanning = true, errorMessage = null) }
        beaconRepository.startScanning()
    }

    fun onStopScan() {
        _uiState.update { it.copy(isScanning = false) }
        beaconRepository.stopScanning()
    }

    fun onErrorDismissed() {
        _uiState.update { it.copy(errorMessage = null) }
    }


    private fun observeBeaconData() {
        beaconRepository.getBeaconInfo()
        .onEach { beacon ->
            val dist = calculateBeaconDistance(beacon)
            _uiState.update { it.copy(beacons=listOf(beacon), beaconDistance = dist) }
        }
        .catch { e -> _uiState.update { it.copy(errorMessage = e.message) }}
        .launchIn(viewModelScope)
    }

}