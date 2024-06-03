package com.sharkdroid.medhavicollege

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sharkdroid.medhavicollege.presentation.navgraph.Route

class MainViewModel:ViewModel() {

    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set


}