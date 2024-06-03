package com.sharkdroid.medhavicollege.presentation.navigationdrawer.calander_events.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.medhavicollege.R

@Composable
fun EventCard(
    eventModule: EventItem
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box( // Use Box for more flexible content arrangement
            modifier = Modifier.background(Color.LightGray.copy(alpha = 0.1f))
        ) {
            Row( // Content row
                modifier = Modifier.padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.news_notification),
                    contentDescription = "News Icon",
                    modifier = Modifier
                        .size(40.dp)
                        .weight(0.2f)
                )
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Column(modifier = Modifier.weight(2f)) {
                    Text(
                        text = eventModule.headline,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 4.dp),
                        maxLines = 2, // Limit text lines to 2 with overflow ellipsis
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = eventModule.date,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.secondary // Use theme color
                    )
                }
            }
        }
    }
}
