package com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events.components.EventCard
import com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events.components.EventItem
import com.sharkdroid.medhavicollege.presentation.news.components.NewsItem
import io.github.boguszpawlowski.composecalendar.StaticCalendar

@Composable
fun CalenderEvents(
    onClick: () -> Unit,
     calenderEventScreenViewModel: CalenderEventScreenViewModel
) {
    Column {

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.colorPrimaryLight))
                .padding(start = 15.dp)
        ) {
            IconButton(onClick = { onClick() }, modifier = Modifier.padding(0.dp)) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = colorResource(
                        id = R.color.black
                    )
                )

            }
            Text(
                text = "Calender & Events",
                fontSize = 20.sp,
                color = colorResource(id = R.color.black)
            )

        }

        // calender
        Box(modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 10.dp, bottom = 15.dp)) {

            StaticCalendar()
        }


        HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider(thickness = 2.dp)

        Column(
            modifier = Modifier
                .padding(top = 15.dp, start = 8.dp)
        ) {
            Text(
                text = "Events:",
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.displayMedium,
            )

            LazyColumn{
                items(calenderEventScreenViewModel.eventItem.value){item ->

                    EventCard(eventModule = item)
                }

            }


        }


    }


}


@Preview(showSystemUi = true)
@Composable
fun CalenderEventsPrev() {

    CalenderEvents( {} , CalenderEventScreenViewModel())



}