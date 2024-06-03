package com.sharkdroid.medhavicollege.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.sharkdroid.medhavicollege.presentation.home.HomeScreen
import com.sharkdroid.medhavicollege.presentation.home.components.CollegePhotoSliderViewModel
import com.sharkdroid.medhavicollege.presentation.medhavi_navigator.MedhaviNavigator

@Composable
fun NavGraph(startDestination:String){

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = startDestination ) {

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.HomeScreen.route
        ){
            composable( route = Route.HomeScreen.route){

                MedhaviNavigator()

            }


            
        }

    }

}