package com.example.brainbob

sealed class NavRoutes(val route:String){
    object FirstScreen: NavRoutes("firstScreen")
    object SecondScreen: NavRoutes("secondScreen")
}
