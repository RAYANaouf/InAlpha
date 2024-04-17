package com.jetapptech.InAlpha

import android.app.Activity
import android.graphics.Color.parseColor
import android.os.Bundle
import android.view.View
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetapptech.InAlpha.model.objects.screens.screens
import com.jetapptech.InAlpha.model.sealed.BottomBarItem
import com.jetapptech.InAlpha.ui.theme.MyApplicationTheme
import com.jetapptech.InAlpha.ui.theme.color3
import com.jetapptech.InAlpha.ui.theme.customWhite
import com.jetapptech.InAlpha.view.material.bottomBar.BottomBar
import com.jetapptech.InAlpha.view.material.topBar.InAlphaTopBar
import com.jetapptech.InAlpha.view.screens.fillScreen.signInScreen.SignInScreen
import com.jetapptech.InAlpha.view.screens.navigated.HomeScreen



private var start by mutableIntStateOf(0)
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

                    val window = LocalView.current.context as Activity

                    SideEffect {

                        window.window.statusBarColor = customWhite.toArgb()

                    }

                    val view = LocalView.current

                    LaunchedEffect(key1 = start ){
                        hideSystemBar(view)
                    }


                    mainScreen()

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        start++
    }
}


@Composable
fun mainScreen() {

    val navController = rememberNavController()
    var selectedBottomBarItem  by rememberSaveable() {
        mutableStateOf(BottomBarItem.Home().name)
    }

    Scaffold(
        topBar = {
            InAlphaTopBar(
                elevation = 4.dp,
                modifier = Modifier
            )
        },
        bottomBar = {
            BottomBar(
                selectedItem = selectedBottomBarItem,
                onClick = {
                    selectedBottomBarItem = it
                    
                }
            )
        },
        containerColor = color3,
        modifier = Modifier
//            .windowInsetsPadding(WindowInsets.statusBars)
    ) {padding->


        NavHost(navController = navController , startDestination = "home" ){

            composable( route = screens.homeScreen ){
                HomeScreen(
                    modifier = Modifier
                        .padding(top = padding.calculateTopPadding() , bottom = padding.calculateBottomPadding())
                )
            }

            composable( route = screens.signInScreen ){
                SignInScreen(
                    modifier = Modifier
                        .padding(top = padding.calculateTopPadding() , bottom = padding.calculateBottomPadding())
                )
            }

        }



    }

}



fun hideSystemBar(view : View){
    val window = (view.context as Activity).window
    val insetsController = WindowCompat.getInsetsController(window, view)

    window.statusBarColor = Color(parseColor("#FFFFFF")).toArgb()

    insetsController.apply {
        hide(WindowInsetsCompat.Type.navigationBars())
        hide(WindowInsetsCompat.Type.statusBars())
        systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }

}
