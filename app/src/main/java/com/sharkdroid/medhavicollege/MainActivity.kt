package com.sharkdroid.medhavicollege

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sharkdroid.medhavicollege.presentation.navgraph.NavGraph
import com.sharkdroid.medhavicollege.ui.theme.CollRed
import com.sharkdroid.medhavicollege.ui.theme.MedhaviCollegeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

private  val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen()
        setContent {
            MedhaviCollegeTheme {
                    val isSystemInDarkMode= isSystemInDarkTheme()
                    val systemController= rememberSystemUiController()

                    SideEffect {
                        systemController.setSystemBarsColor(
                            color = Color(0xFFC0C0C0),
                            darkIcons = !isSystemInDarkMode
                        )
                    }

                      Box(modifier= Modifier
                          .background(MaterialTheme.colorScheme.background)
                          .padding(top = 35.dp)) {
                           Spacer(modifier = Modifier.height(32.dp))
                          val startDestination= mainViewModel.startDestination
                          NavGraph(startDestination = startDestination)
                      }



            }
        }
    }
}

