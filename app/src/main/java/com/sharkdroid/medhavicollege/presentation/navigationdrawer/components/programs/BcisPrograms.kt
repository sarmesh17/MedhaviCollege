package com.sharkdroid.medhavicollege.presentation.navigationdrawer.components.programs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun BcisPrograms(
    onClick:() -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(15.dp), verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.colorPrimaryLight))
            .padding(start = 15.dp)) {
            IconButton(onClick = { onClick() }, modifier = Modifier.padding(0.dp) ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = colorResource(
                    id = R.color.black
                ))

            }
            Text(text = "BCIS(IT) Program", fontSize = 20.sp, color = colorResource(id = R.color.black))

        }



        Image(painter = painterResource(id = R.drawable.bcis_it), contentDescription = null)



        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "BCIS(IT)",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(
                    id = R.color.black
                )
            )
        }
        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(id = R.string.bcis),
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
            lineHeight = 25.sp,
            modifier = Modifier.padding(top = 5.dp, start = 10.dp, end = 10.dp),
            color = colorResource(id = R.color.black)
        )
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BcisProgramsPrev() {
    MedhaviCollegeTheme {
        BcisPrograms({})
    }

}

