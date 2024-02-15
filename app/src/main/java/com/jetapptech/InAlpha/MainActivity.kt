package com.jetapptech.InAlpha

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jetapptech.InAlpha.ui.theme.MyApplicationTheme
import com.jetapptech.InAlpha.ui.theme.color3
import com.jetapptech.InAlpha.ui.theme.customWhite
import com.jetapptech.InAlpha.view.material.topBar.InAlphaTopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

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
                    .background(customWhite)
            )
        },
        containerColor = color3
    ) {padding->

        padding.calculateTopPadding()




    }

}
