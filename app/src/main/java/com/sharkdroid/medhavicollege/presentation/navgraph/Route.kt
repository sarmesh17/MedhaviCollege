package com.sharkdroid.medhavicollege.presentation.navgraph

sealed class Route( val route: String) {

    object AppStartNavigation:Route("appStartNavigation")
    object HomeScreen:Route("homeScreen")
    object NewsScreen:Route("newsScreen")
    object SupportScreen:Route("supportScreen")
    object BCSITScreen:Route("bcsitScreen")
    object BBAScreen:Route("BbaScreen")
    object BHMScreen:Route("bhmScreen")
    object AdministratorScreen:Route("administratorScreen")
    object CalenderEventScreen:Route("calenderEventScreen")

}