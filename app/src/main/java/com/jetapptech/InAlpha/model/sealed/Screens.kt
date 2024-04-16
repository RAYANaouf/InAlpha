package com.jetapptech.InAlpha.model.sealed

import com.jetapptech.InAlpha.model.objects.screens.screens

sealed class Screens(val root : String){

    class HomeScreen : Screens(root = screens.homeScreen)
    class SignInScreen : Screens(root = screens.signInScreen)

}
