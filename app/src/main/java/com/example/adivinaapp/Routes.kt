package com.example.adivinaapp

sealed class Routes (val route: String){
    object MenuScreen: Routes("MenuScreen")
    object GameScreen: Routes("GameScreen")
}