package com.sharkdroid.medhavicollege.presentation.navigationdrawer.college_management

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.ui.theme.MedhaviCollegeTheme

@Composable
fun CollegeAdministration(
    onclick:() -> Unit
) {
    val scrollState= rememberScrollState()


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(15.dp), verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.colorPrimaryLight))
            .padding(start = 5.dp)) {
            IconButton(onClick = { onclick() }, modifier = Modifier.padding(0.dp) ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = colorResource(
                    id = R.color.black
                ))

            }
            Text(text = "College Administration", fontSize = 20.sp, color = colorResource(id = R.color.black))

        }
         Spacer(modifier = Modifier.height(25.dp))
        //principal-section
        Image(painter = painterResource(id = R.drawable.principal), contentDescription = null, modifier = Modifier
            .clip(
                CircleShape
            )
            .size(200.dp)
            .border(width = 1.dp, color = colorResource(id = R.color.colorPrimaryLight)))
            

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Jay Ram Khanal (Principal)", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = colorResource(
                id = R.color.black
            )
            )
        }
        HorizontalDivider(thickness = 2.dp, color = Color.LightGray)

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = stringResource(id = R.string.about_principal), textAlign = TextAlign.Justify, fontSize = 16.sp, lineHeight = 25.sp, modifier = Modifier.padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp), color = colorResource(
            id = R.color.black
        ),
        )
        //bcis-cordinator-section

          HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(id = R.drawable.bcis_cordinator), contentDescription = null, modifier = Modifier
            .clip(
                CircleShape
            )
            .size(200.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Niranjan Chandra Shapkota (BCSIT Coordinator)", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = colorResource(
                id = R.color.black
            )
            )
        }
        HorizontalDivider(thickness = 2.dp, color = Color.LightGray)

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = stringResource(id = R.string.about_bcis_coordinator), textAlign = TextAlign.Justify, fontSize = 16.sp, lineHeight = 25.sp, modifier = Modifier.padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp), color = colorResource(
            id = R.color.black
        )
        )

        //BBA-coordinator

        HorizontalDivider(thickness = 2.dp)
        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(id = R.drawable.bba_cordinator), contentDescription = null, modifier = Modifier
            .clip(
                CircleShape
            )
            .size(200.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Kamal Panta (BBA Coordinator)", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = colorResource(
                id = R.color.black
            )
            )
        }
        HorizontalDivider(thickness = 2.dp, color = Color.LightGray)

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = stringResource(id = R.string.about_bba_coordinator), textAlign = TextAlign.Justify, fontSize = 16.sp, lineHeight = 25.sp, modifier = Modifier.padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 10.dp), color = colorResource(
            id = R.color.black
        )
        )









    }

}


@Preview(showBackground = true, showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CollegeAdministrationPrev() {
    MedhaviCollegeTheme {
        CollegeAdministration({})
    }

}
