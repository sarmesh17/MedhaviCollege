package com.sharkdroid.medhavicollege.presentation.news.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sharkdroid.medhavicollege.R
import com.sharkdroid.medhavicollege.presentation.Dimension.ExtraSmallPadding1
import com.sharkdroid.medhavicollege.presentation.Dimension.IconSize

@Composable
fun MedhaviBottomNavigation(

    items: List<BottomNavigationItem>,
    selected: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth().size(height = 100.dp, width = 0.dp),
        containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.95f),
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selected,
                onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                            modifier = Modifier.size(IconSize)
                        )
                        Spacer(modifier = Modifier.height(ExtraSmallPadding1))
                        Text(text = item.text, style = MaterialTheme.typography.labelSmall)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.LightBlue),
                    selectedTextColor = colorResource(id = R.color.LightBlue),
                    unselectedTextColor = colorResource(id = R.color.LightGrey),
                    unselectedIconColor =  colorResource(id = R.color.LightGrey)

                )
            )
        }
    }

}


data class BottomNavigationItem(
    @DrawableRes val icon: Int,
    val text: String
)