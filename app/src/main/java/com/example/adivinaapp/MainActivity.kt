package com.example.adivinaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adivinaapp.view.GameScreen
import com.example.adivinaapp.view.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Routes.MenuScreen.route
            )
            {
                composable(Routes.MenuScreen.route)
                {
                    MenuScreen(navController)
                }
                composable(Routes.GameScreen.route)
                {
                    GameScreen(navController)
                }
            }
        }
    }
}