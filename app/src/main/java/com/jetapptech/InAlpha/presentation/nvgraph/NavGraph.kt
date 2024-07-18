package com.jetapptech.InAlpha.presentation.nvgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetapptech.InAlpha.model.sealed.Screens
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.OnBoardingScreen
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.onBoardingScreen.viewModel.OnBoardingViewModel
import com.jetapptech.InAlpha.presentation.view.screens.fillScreen.signInScreen.SignInScreen
import com.jetapptech.InAlpha.presentation.view.screens.navigated.HomeScreen

@Composable
fun NavGraph(
    navController    : NavHostController = rememberNavController(),
    startDestination : String     ,
    onShowBars       : (Boolean , Boolean)->Unit = {top,bottom->} ,
    paddingValues    : PaddingValues
) {


    NavHost(navController = navController , startDestination = startDestination ){

        composable( route = Routes.StartDestinationNVGraphScreen.routes ){
            onShowBars(false,false)
        }


        composable( route = Routes.HomeScreen.routes ){
            onShowBars(true,true)
            HomeScreen(
                modifier = Modifier
                    .padding(top = paddingValues.calculateTopPadding() , bottom = paddingValues.calculateBottomPadding())
            )
        }

        composable( route = Screens.SignInScreen().name ){
            onShowBars(false,false)
            SignInScreen(
                modifier = Modifier
                    .padding(top = paddingValues.calculateTopPadding() , bottom = paddingValues.calculateBottomPadding())
            )
        }

        composable( route = Routes.OnBoardingScreen.routes ){
            onShowBars(false,false)
            val viewModel : OnBoardingViewModel = hiltViewModel()

            OnBoardingScreen(
                modifier = Modifier
                    .padding(top = paddingValues.calculateTopPadding() , bottom = paddingValues.calculateBottomPadding()),
                onEven = viewModel::onEvent
            )
        }


    }


}