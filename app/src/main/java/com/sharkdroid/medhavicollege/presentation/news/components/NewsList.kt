package com.sharkdroid.medhavicollege.presentation.news.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.news.NewsViewModel
import com.sharkdroid.medhavicollege.ui.theme.MedhaviCollegeTheme


@Composable
fun NewsList(
     onClick:() -> Unit,
     newsViewModel: NewsViewModel
){

Column{
    Row(horizontalArrangement = Arrangement.spacedBy(15.dp), verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.colorPrimaryLight))
        .padding(start = 15.dp)) {
        IconButton(onClick = { onClick() } ) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = colorResource(
                id = R.color.black
            )
            )

        }
        Text(text = "News", fontSize = 20.sp, color = colorResource(id = R.color.black))

    }

    LazyColumn(Modifier.fillMaxWidth(),verticalArrangement = Arrangement.spacedBy(8.dp) // Add spacing between items
    ){

        items(newsViewModel.newsItems.value){ newsItem ->

            NewsCard(newsItem = newsItem)
        }
    }


}


}

@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)

@Composable
fun NewsListPrev(){
    MedhaviCollegeTheme {

        NewsList(newsViewModel = NewsViewModel(), onClick = {})
    }
}