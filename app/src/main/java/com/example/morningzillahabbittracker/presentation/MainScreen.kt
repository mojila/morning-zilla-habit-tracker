package com.example.morningzillahabbittracker.presentation

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.morningzillahabbittracker.R
import com.example.morningzillahabbittracker.presentation.navigation.init
import com.example.morningzillahabbittracker.presentation.theme.MorningZillaHabitTrackerTheme

@Composable
fun MainScreen(context: Context) {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "main"
    ) {
        init(context, navController)
    }
}

@Composable
fun WearApp(navController: NavController) {
    MorningZillaHabitTrackerTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Greeting()
                Spacer(modifier = Modifier.height(Dp(10F)))
                ButtonStartTrack(navController)
            }
        }
    }
}

@Composable
fun ButtonStartTrack(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier.width(Dp(200F)).background(MaterialTheme.colors.primary),
            onClick = {
                navController.navigate("formScreen")
            }
        ) {
            Text(text = "Track Today!")
        }
    }
}

@Composable
fun Greeting() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.width(Dp(200F)),
            textAlign = TextAlign.Center,
            text = stringResource(R.string.hello_world)
        )
    }
}