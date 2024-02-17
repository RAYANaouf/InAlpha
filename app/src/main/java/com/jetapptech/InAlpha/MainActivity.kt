package com.jetapptech.InAlpha

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetapptech.InAlpha.ui.theme.MyApplicationTheme
import com.jetapptech.InAlpha.ui.theme.color3
import com.jetapptech.InAlpha.ui.theme.customWhite
import com.jetapptech.InAlpha.view.material.topBar.InAlphaTopBar
import com.jetapptech.InAlpha.view.screens.navigated.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        WindowCompat.setDecorFitsSystemWindows(window , false)


        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    mainScreen()

                }
            }
        }
    }
}


@Composable
fun mainScreen() {

    val window = LocalView.current.context as Activity

    SideEffect {

        window.window.statusBarColor = customWhite.toArgb()

    }

    Scaffold(
        topBar = {
            InAlphaTopBar(
                modifier = Modifier
                    .height(55.dp)
                    .background(customWhite)
            )
        },
        containerColor = color3,
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {padding->


        val navController = rememberNavController()

        NavHost(navController = navController , startDestination = "home" ){

            composable( route = "home" ){
                HomeScreen(
                    modifier = Modifier
                        .padding(top = padding.calculateTopPadding())
                )
            }

        }



    }

}
