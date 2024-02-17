package com.jetapptech.InAlpha.model.sealed

sealed class Screens(val root : String){

    class HomeScreen : Screens(root = "home_screen")

}
