package com.jetapptech.InAlpha.presentation.nvgraph

import com.jetapptech.InAlpha.model.objects.screens.screens
import com.jetapptech.InAlpha.model.sealed.Screens

sealed class Routes (
    val routes: String
){

    object StartDestinationNVGraphScreen : Routes( routes = "startDestinationNVGraph")
    object OnBoardingScreen : Routes( routes = "onBoardingScreen")
    object HomeScreen       : Routes( routes = "homeScreen")
    object SignInScreen     : Routes( routes = "signInScreen")
    object Basket           : Routes( routes = "basketScreen")
    object Creativity       : Routes( routes = "creativityScreen")
    object Reels            : Routes( routes = "reelsScreen")

}
