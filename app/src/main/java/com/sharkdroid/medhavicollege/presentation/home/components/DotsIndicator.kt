package com.sharkdroid.medhavicollege.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DotsIndicator(
    modifier:Modifier=Modifier,
    totalDots:Int,
    selectedIndex:Int,
    selectedColor:Color=MaterialTheme.colorScheme.primary,
    unSelectedColor:Color=Color.Gray
){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
       for(i in 0 until totalDots){

           val  color= if (i == selectedIndex) selectedColor else unSelectedColor

           Box(modifier = modifier.padding(4.dp)
               .size(8.dp)
               .background(color = color, shape = CircleShape)

           )
       }
    }

}