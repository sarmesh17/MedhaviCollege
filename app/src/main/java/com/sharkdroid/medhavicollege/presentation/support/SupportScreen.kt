package com.sharkdroid.medhavicollege.presentation.support

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.google.map.CollegeMap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.sharkdroid.medhavicollege.ui.theme.MedhaviCollegeTheme
import com.sharkdroid.medhavicollege.util.Constant.FACEBOOK_URL
import com.sharkdroid.medhavicollege.util.Constant.INSTAGRAM_URL
import com.sharkdroid.medhavicollege.util.Constant.MAIL_ID
import com.sharkdroid.medhavicollege.util.Constant.PHONE_NUMBER
import com.sharkdroid.medhavicollege.util.Constant.WEBSITE_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportScreen(onBackClick: () -> Unit) {
    val context = LocalContext.current
    val infiniteTransition = rememberInfiniteTransition(label = "") // remember state of transition
    val animatedOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val gradientBrush = Brush.linearGradient(
        colors = listOf(
            Color.Red,
            Color.Blue
        ),
        start = Offset.Zero,
        end = Offset(animatedOffset * 3000f, animatedOffset * 3000f)
    )
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState, enabled = true),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = { onBackClick() }, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = colorResource(id = R.color.black)
                )
            }
            Text(text = "Support", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                id = R.color.black
            ))

        }
        Image(
            painter = painterResource(id = R.drawable.medhavilogo),
            modifier = Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(
                    width = 5.dp,
                    brush = gradientBrush,
                    shape = CircleShape
                )
                .size(180.dp),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(16.dp)) // Add some space between the icon and the text

        HorizontalDivider(thickness = 4.dp)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Get in Touch",
                fontSize = 35.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 10.dp),
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(
                    id = R.color.black
                )
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = "Have questions? Get in touch with us!",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,color = colorResource(
                    id = R.color.black
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            //phoneButton
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_DIAL).also {
                        it.data = Uri.parse("tel:$PHONE_NUMBER")

                    }
                    context.startActivity(intent)
                },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(60.dp), colors = ButtonDefaults.buttonColors(
                    Color.Transparent, contentColor = MaterialTheme.colorScheme.onSurface
                ), border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.phonecall),
                        contentDescription = "Phone Icon",
                        Modifier
                            .padding(start = 10.dp, end = 50.dp)
                            .size(33.dp)
                    )
                    Text(text = "01-4792561", fontSize = 20.sp)
                }


            }
            Spacer(modifier = Modifier.height(25.dp))

            // email- button
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).also {
                        it.data = Uri.parse("mailto: $MAIL_ID")
                    }
                    context.startActivity(intent)

                },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(60.dp), colors = ButtonDefaults.buttonColors(
                    Color.Transparent, contentColor = MaterialTheme.colorScheme.onSurface
                ), border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.mail),
                        contentDescription = "Phone Icon",
                        Modifier
                            .padding(start = 10.dp, end = 15.dp)
                            .size(33.dp)
                    )
                    Text(text = "info@medhavicollege.edu.np", fontSize = 18.sp, maxLines = 1)
                }


            }
            Spacer(modifier = Modifier.height(30.dp))
            HorizontalDivider(thickness = 4.dp)

            Text(
                text = "Social Media",
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(
                    id = R.color.black
                )
            )

            //social media button

            //facebook
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_URL))
                    context.startActivity(intent)
                },

                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(60.dp), colors = ButtonDefaults.buttonColors(
                    Color.Transparent, contentColor = MaterialTheme.colorScheme.onSurface
                ), border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "facebook icon",
                        Modifier
                            .padding(start = 10.dp, end = 8.dp)
                            .size(33.dp)
                    )
                    Text(
                        text = "www.facebook.com/medhavi.college",
                        fontSize = 15.sp,
                        maxLines = 1
                    )
                }


            }
            Spacer(modifier = Modifier.height(25.dp))
            // instagram
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(INSTAGRAM_URL))
                    context.startActivity(intent)
                },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(60.dp), colors = ButtonDefaults.buttonColors(
                    Color.Transparent, contentColor = MaterialTheme.colorScheme.onSurface
                ), border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.instagram),
                        contentDescription = "Phone Icon",
                        Modifier
                            .padding(start = 10.dp, end = 15.dp)
                            .size(33.dp)
                    )
                    Text(text = "medhavicollegenepal", fontSize = 15.sp, maxLines = 1)
                }

            }
            Spacer(modifier = Modifier.height(25.dp))
            // web
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(WEBSITE_URL))
                    context.startActivity(intent)
                },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(60.dp), colors = ButtonDefaults.buttonColors(
                    Color.Transparent, contentColor = MaterialTheme.colorScheme.onSurface
                ), border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.web),
                        contentDescription = "Phone Icon",
                        Modifier
                            .padding(start = 10.dp, end = 15.dp)
                            .size(33.dp)
                    )
                    Text(text = "medhavicollege.edu.np", fontSize = 15.sp, maxLines = 1)
                }

            }

            Spacer(modifier = Modifier.height(25.dp))
            HorizontalDivider(thickness = 4.dp)
            //Location
            Text(
                text = "Location",
                fontSize = 25.sp,
                modifier = Modifier.padding(top = 15.dp, bottom = 10.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(
                    id = R.color.black
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            // college location -> 27.683668237948858, 85.33379961926609
//                CollegeMap(latitude = 40.6892, longitude = -74.0445 ) MAP SDK not enabled

            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .clip(RoundedCornerShape(30.dp))
            )

        }
    }

}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun SupportScreenPrev() {
    MedhaviCollegeTheme {

        SupportScreen(onBackClick = {})
    }
}
