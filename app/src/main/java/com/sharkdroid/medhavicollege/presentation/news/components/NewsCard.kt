package com.sharkdroid.medhavicollege.presentation.news.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.ui.theme.MedhaviCollegeTheme
import java.util.Date

@Composable
fun NewsCard(
    newsItem: NewsItem
) {

    Column {

        Card(
            elevation = CardDefaults.elevatedCardElevation(15.dp), modifier = Modifier
                .padding(top = 45.dp, start = 15.dp, end = 15.dp)
                .clip(
                    RoundedCornerShape(15.dp)
                )
        ) {
            Image(painter = painterResource(newsItem.image), contentDescription = null)
            Box(
                contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, bottom = 10.dp)
            ) {

                Text(
                    text = newsItem.headline,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Justify,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 5.dp),
                    color = colorResource(id = R.color.black)
                )
            }
            Text(
                text = newsItem.date.toString(), fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, start = 5.dp),
                color = colorResource(id = R.color.black)
            )
            HorizontalDivider(thickness = 3.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = newsItem.description,
                fontSize = 15.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(bottom = 25.dp, start = 10.dp, end = 10.dp),
                color = colorResource(id = R.color.black)

            )
        }

    }

}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun NewsCardPrev() {
    MedhaviCollegeTheme {

        NewsCard(
            newsItem = NewsItem(
                R.drawable.admissionopen,
                "Admission Open for BCSIT, BBA, BHA Programs",
                "Enroll now in our BCSIT, BBA, and BHA programs! Apply today to start your journey toward a successful career.",
                date = Date()
            )
        )
    }
}
