package com.example.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.navegacion.views.DetailView
import com.example.navegacion.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
            navArgument("opcional"){type = NavType.StringType},
        )){
            val id = it.arguments?.getInt("id")?: 0
            val it = null
            val opcional = it.arguments?.getString("opcional")?: ""
            DetailView(navController, id , opcional )
        }
    }
}