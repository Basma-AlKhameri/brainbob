package com.example.brainbob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.brainbob.screens.FirstScreen
import com.example.brainbob.screens.SecondScreen
import com.example.brainbob.ui.theme.BrainbobTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrainbobTheme {
                nav()



            }
        }
    }
}

@Composable
fun nav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.FirstScreen.route,
    )
    {
        composable(NavRoutes.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(NavRoutes.SecondScreen.route) {
            SecondScreen(navController = navController)
        }
    }
}
