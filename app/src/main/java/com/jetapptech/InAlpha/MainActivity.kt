package com.jetapptech.InAlpha

import android.app.Activity
import android.graphics.Color.parseColor
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jetapptech.InAlpha.data.manager.LocalUserManagerImp
import com.jetapptech.InAlpha.domain.usecases.appEntryUseCases.AppEntryUseCases
import com.jetapptech.InAlpha.model.sealed.Screens
import com.jetapptech.InAlpha.presentation.nvgraph.NavGraph
import com.jetapptech.InAlpha.presentation.ui.theme.MyApplicationTheme
import com.jetapptech.InAlpha.presentation.ui.theme.color3
import com.jetapptech.InAlpha.presentation.ui.theme.customWhite
import com.jetapptech.InAlpha.presentation.view.material.bottomBar.BottomBar
import com.jetapptech.InAlpha.presentation.view.material.topBar.InAlphaTopBar
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.signInScreen.SignInScreen
import com.jetapptech.InAlpha.presentation.view.screens.navigated.HomeScreen
//import com.jetapptech.InAlpha.viewmodel.InAlphaViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


private var start by mutableIntStateOf(0)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                mainViewModel.splashCondition
            }
        }



        WindowCompat.setDecorFitsSystemWindows(window , false)


        setContent {


            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    val viewModel : InAlphaViewModel by viewModels()

                    val window = LocalView.current.context as Activity

                    SideEffect {

                        window.window.statusBarColor = customWhite.toArgb()

                    }

                    val view = LocalView.current

                    LaunchedEffect(key1 = start ){
                        hideSystemBar(view)
                    }





                    mainScreen(
                        mainViewModel.startDestination,
                        mainViewModel
                    )

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
fun mainScreen(
    startDestination : String ,
    viewModel: MainViewModel
    ) {

    val navController = rememberNavController()

    var selectedBottomBarItem  by rememberSaveable() {
        mutableStateOf(Screens.HomeScreen().name)
    }


    var visible_topBar  by rememberSaveable() {
        mutableStateOf(true)
    }

    var visible_bottomBar  by rememberSaveable() {
        mutableStateOf(true)
    }



    Scaffold(
        topBar = {
            Column {
                AnimatedVisibility(visible = visible_topBar  ) {
                    InAlphaTopBar(
                        elevation = 4.dp,
                        onClick = {
                            navController.navigate(Screens.SignInScreen().name)
                        },
                        modifier = Modifier
                    )
                }
            }
        },
        bottomBar = {
            Column {
                AnimatedVisibility(visible = visible_bottomBar ) {
                    BottomBar(
                        selectedItem = selectedBottomBarItem,
                        onClick = {
                            selectedBottomBarItem = it
                        }
                    )
                }
            }
        },
        containerColor = color3,
        modifier = Modifier
//            .windowInsetsPadding(WindowInsets.statusBars)
    ) {padding->

        NavGraph(
            navController    = navController,
            startDestination = startDestination ,
            paddingValues    = padding,
            onShowBars       = {top,bottom->
                if (top != visible_topBar){
                    visible_topBar = top
                }
                if (bottom != visible_bottomBar){
                    visible_bottomBar = bottom
                }
            }
        )


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
