package com.sharkdroid.medhavicollege.presentation.google.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.ktx.model.cameraPosition

@Composable
fun CollegeMap(latitude: Double, longitude: Double) {
    val mapState = rememberCameraPositionState() // Remember the camera state
    GoogleMap(cameraPositionState = mapState) { // Pass the state to GoogleMap

        // Set the initial camera position on launch
        LaunchedEffect(Unit) {
            mapState.move(CameraUpdateFactory.newLatLngZoom(LatLng(latitude, longitude), 15f))
        }


    }
}
