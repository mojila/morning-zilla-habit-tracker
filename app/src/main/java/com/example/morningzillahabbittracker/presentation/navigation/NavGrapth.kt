package com.example.morningzillahabbittracker.presentation.navigation

import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.morningzillahabbittracker.presentation.Form
import com.example.morningzillahabbittracker.presentation.WearApp

fun NavGraphBuilder.init(
    context: Context,
    navController: NavController
) {
    navigation(
        route = "main",
        startDestination = "formScreen"
    ) {
        composable("mainScreen") {
            WearApp(navController)
        }
        composable("formScreen") {
            Form(navController)
        }
    }
}