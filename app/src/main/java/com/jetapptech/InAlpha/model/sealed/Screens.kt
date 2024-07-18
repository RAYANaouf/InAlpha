package com.jetapptech.InAlpha.model.sealed

import com.jetapptech.InAlpha.model.objects.screens.screens

sealed class Screens(val name : String){

    class HomeScreen   : Screens(name = screens.home)
    class SignInScreen : Screens(name = screens.signIn)
    class Basket       : Screens(name = screens.basket)
    class Creativity   : Screens(name = screens.creativity)
    class Reels        : Screens(name = screens.reels)

}
