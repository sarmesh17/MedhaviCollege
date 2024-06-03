package com.sharkdroid.medhavicollege.presentation.navigationdrawer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.navgraph.Route
import kotlinx.coroutines.launch



// Function to create the content of the drawer
@Composable
fun DrawerContent(navController: NavController, drawerState: DrawerState) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.75f)
            .background(colorResource(id = R.color.LightGrey)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header of the drawer
          Image(painter = painterResource(id = R.drawable.medhavilogo), contentDescription = null, modifier = Modifier
              .clip(CircleShape)
              .size(150.dp)
              .padding(top = 25.dp) )
        // Divider below the header
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(color = Color.Gray, modifier = Modifier.padding(end = 31.dp))

        // List of items in the drawer
        DrawerItem(item = "Program", navController = navController, drawerState = drawerState)

         listOf("College Administration", "Calender & Events").forEach {

            NonDropDownDrawerItem(it, navController = navController,drawerState=drawerState)
        }

    }
}

// Function to create each item in the drawer
@Composable
fun DrawerItem(item: String, navController: NavController, drawerState: DrawerState) {
    val expanded = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()


    Column {
        // Row to display the item and arrow icon for the dropdown
        Row(
            modifier = Modifier
                .clickable { expanded.value = !expanded.value } // Toggle dropdown when clicked
                .padding(top = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = item,
                fontSize = 16.sp, modifier = Modifier.padding(start = 30.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            // Arrow icon to indicate the expandable state
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
        // AnimatedVisibility to show/hide the dropdown with fade-in/fade-out animations
        AnimatedVisibility(
            visible = expanded.value,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            // Column to contain the dropdown items
            Column(modifier = Modifier.padding(start = 16.dp)) {
                // Sub-items in the dropdown
                listOf("BCIS(IT)", "BBA", "BHM").forEach { subItem ->
                    Text(
                        text = subItem,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .clickable {
                                coroutineScope.launch {
                                    drawerState.close()
                                    when (subItem) {
                                        "BCIS(IT)" -> navController.navigate(Route.BCSITScreen.route)
                                        "BBA" -> navController.navigate(Route.BBAScreen.route)
                                        "BHM" -> navController.navigate(Route.BHMScreen.route)
                                    }
                                }
                            }
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun NonDropDownDrawerItem(item: String,navController: NavController,drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()

    // Row to display the item and arrow icon for the dropdown
    Column(
        modifier = Modifier
            .clickable { } // Toggle dropdown when clicked
            .padding(start = 16.dp)
            .fillMaxWidth(),

        ) {

        Text(
            text = item,
            style = MaterialTheme.typography.bodySmall,
            color = colorResource(id = R.color.black),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable {
                    coroutineScope.launch {
                        drawerState.close()
                        when (item) {

                            "College Administration" -> navController.navigate(Route.AdministratorScreen.route)
                            "Calender & Events" -> navController.navigate(Route.CalenderEventScreen.route)
                        }
                    }
                }
            ,
            fontSize = 16.sp

        )
    }

}


