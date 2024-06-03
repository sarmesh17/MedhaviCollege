package com.sharkdroid.medhavicollege.presentation.medhavi_navigator

import androidx.compose.foundation.layout.Box
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.DrawerContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.home.HomeScreen
import com.sharkdroid.medhavicollege.presentation.home.components.CollegePhotoSliderViewModel
import com.sharkdroid.medhavicollege.presentation.navgraph.Route
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events.CalenderEventScreenViewModel
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events.CalenderEvents
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.college_management.CollegeAdministration
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.components.programs.BBAPrograms
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.components.programs.BHMPrograms
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.components.programs.BcisPrograms
import com.sharkdroid.medhavicollege.presentation.news.NewsViewModel
import com.sharkdroid.medhavicollege.presentation.news.components.BottomNavigationItem
import com.sharkdroid.medhavicollege.presentation.news.components.MedhaviBottomNavigation
import com.sharkdroid.medhavicollege.presentation.news.components.NewsList
import com.sharkdroid.medhavicollege.presentation.support.SupportScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MedhaviNavigator() {
    val bottomNavigationItem = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.home, "Home"),
            BottomNavigationItem(icon = R.drawable.news_icon, "News"),
            BottomNavigationItem(icon = R.drawable.support, "Support")
        )
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val backstackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    selectedItem = when (backstackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.NewsScreen.route -> 1
        Route.SupportScreen.route -> 2
        else -> 0
    }

    val isHomeScreen = backstackState?.destination?.route == Route.HomeScreen.route

    if (isHomeScreen) {
        ModalNavigationDrawer(
            drawerContent = { DrawerContent(navController = navController, drawerState = drawerState) },
            drawerState = drawerState
        ) {
            MainContent(navController = navController, drawerState = drawerState, bottomNavigationItem = bottomNavigationItem, selectedItem = selectedItem, coroutineScope = coroutineScope, isHomeScreen = true)
        }
    } else {
        MainContent(navController = navController, drawerState = drawerState, bottomNavigationItem = bottomNavigationItem, selectedItem = selectedItem, coroutineScope = coroutineScope, isHomeScreen = false)
    }
}

@Composable
fun MainContent(
    navController: NavHostController,
    drawerState: DrawerState,
    bottomNavigationItem: List<BottomNavigationItem>,
    selectedItem: Int,
    coroutineScope: CoroutineScope,
    isHomeScreen: Boolean
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            MedhaviBottomNavigation(items = bottomNavigationItem, selected = selectedItem) { index ->
                when (index) {
                    0 -> navigateToTab(navController = navController, route = Route.HomeScreen.route)
                    1 -> navigateToTab(navController = navController, route = Route.NewsScreen.route)
                    2 -> navigateToTab(navController = navController, route = Route.SupportScreen.route)
                }
            }
        },
        topBar = {
            if (isHomeScreen) {
                Box(modifier = Modifier.fillMaxWidth().padding(top = 12.dp)){

                    IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null, modifier = Modifier.size(24.dp))
                    }
                }
            }
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        ) {
            composable(route = Route.HomeScreen.route) {
                val collegePhotoSliderViewModel: CollegePhotoSliderViewModel = hiltViewModel()
                HomeScreen(collegePhotoSliderViewModel = collegePhotoSliderViewModel)
            }
            composable(route = Route.NewsScreen.route) {
                val newsViewModel: NewsViewModel = hiltViewModel()
                NewsList(onClick = { navController.popBackStack() }, newsViewModel)
            }
            composable(route = Route.SupportScreen.route) {
                SupportScreen { navController.popBackStack() }
            }
            composable(route = Route.BCSITScreen.route) {
                BcisPrograms { navController.popBackStack() }
            }
            composable(route = Route.BBAScreen.route) {
                BBAPrograms { navController.popBackStack() }
            }
            composable(route = Route.BHMScreen.route) {
                BHMPrograms { navController.popBackStack() }
            }
            composable(route = Route.AdministratorScreen.route) {
                CollegeAdministration { navController.popBackStack() }
            }
            composable(route = Route.CalenderEventScreen.route) {
                val viewModel: CalenderEventScreenViewModel = hiltViewModel()
                CalenderEvents(onClick = { navController.popBackStack() }, calenderEventScreenViewModel = viewModel)
            }
        }
    }
}

fun navigateToTab(navController: NavHostController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}
