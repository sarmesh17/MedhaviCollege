package com.sharkdroid.medhavicollege.presentation.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollegePhotoSlider(
    collegePhotoSliderViewModel: CollegePhotoSliderViewModel
) {
    val imagesResIds = collegePhotoSliderViewModel.imageList

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { imagesResIds.size })

    Column {
        HorizontalPager(state = pagerState) { page ->
            Card( // Wrap the image in a Card for elevation and shadow
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f), // Specify aspect ratio
                elevation =CardDefaults.cardElevation(8.dp), // Adjust elevation as desired
                shape = RoundedCornerShape(4.dp) // Round corners for the card
            ) {
                Image(
                    painter = painterResource(id = imagesResIds[page]),
                    contentDescription = "college photo",
                    contentScale = ContentScale.FillWidth
                )
            }
        }


        LaunchedEffect(key1 = Unit) {
            while (true) {
                delay(3000) // transition speed
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % imagesResIds.size)
            }
        }
        //Dots Indicator
        DotsIndicator(
            totalDots = imagesResIds.size,
            selectedIndex = pagerState.currentPage,
            modifier = Modifier.padding(16.dp),
        )

    }


}

