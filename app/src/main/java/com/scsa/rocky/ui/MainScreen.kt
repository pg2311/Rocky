package com.scsa.rocky.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = {
            if (uiState.isScanning) viewModel.onStopScan() else viewModel.onStopScan()
        }) { Text(if (uiState.isScanning) "Stop Scan" else "Start Scan") }

        Spacer(Modifier.height(16.dp))

        LazyColumn(Modifier.weight(1f)) {
            items(uiState.beacons, key = {it.uuid}) { beacon ->
                Text("Beacon ${beacon.uuid}")
            }
        }

        uiState.beaconDistance?.let { result ->
            Text("Distance: $result")
        }

        uiState.errorMessage?.let {
            Text("Error: $it")
        }
    }
}