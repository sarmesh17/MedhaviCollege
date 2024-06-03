package com.sharkdroid.medhavicollege.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.home.components.CollegePhotoSlider
import com.sharkdroid.medhavicollege.presentation.home.components.CollegePhotoSliderViewModel
import com.sharkdroid.medhavicollege.ui.theme.MedhaviCollegeTheme
import dagger.Provides


@Composable
fun HomeScreen(
    collegePhotoSliderViewModel: CollegePhotoSliderViewModel= hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize(
        )
    ) {

        HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp, start = 50.dp, end = 16.dp),
            horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically // Center elements horizontally
        ) {


            Image(
                painter = painterResource(id = R.drawable.medhavilogo),
                contentDescription = "College Logo",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)

            )
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Text(
                text = "Medhavi College", // Replace with your college name
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterVertically)// Assign weight for logo and text to fit side-by-side
            )
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
        )
        
        Spacer(modifier = Modifier.height(10.dp))
        
        CollegePhotoSlider(collegePhotoSliderViewModel = collegePhotoSliderViewModel)

        HorizontalDivider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
        )

        Text(
            text = stringResource(id = R.string.collegeIntro),
            fontSize = 16.sp,
            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(state = rememberScrollState()),
            style = MaterialTheme.typography.bodyLarge.merge(letterSpacing = 0.1.sp)

        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPrev(){

HomeScreen()

}



