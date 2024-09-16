package com.example.morningzillahabbittracker.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Picker
import androidx.wear.compose.material.Text

@Composable
fun Form(navController: NavController) {
    var bodyWeight by remember { mutableFloatStateOf(70F) }

    Box(
        modifier = Modifier.fillMaxWidth().padding(
            top = Dp(10F)
        ),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Text(text = "Body weight (kg)", textAlign = TextAlign.Center, fontSize = TextUnit(20F, TextUnitType.Sp))
                }
            }
            Spacer(
                modifier = Modifier.height(Dp(10F))
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ButtonDecrease(
                        onClick = {
                            if (bodyWeight < 1) return@ButtonDecrease

                            bodyWeight -= 0.01F
                        }
                    )
                    Text(
                        text = String.format(format = "%.2f", bodyWeight),
                        fontSize = TextUnit(
                            value = 50F,
                            type = TextUnitType.Sp
                        ),
                        modifier = Modifier.padding(
                            start = 5.dp,
                            end = 5.dp,
                        )
                    )
                    ButtonIncrease(
                        onClick = {
                            bodyWeight += 0.01F
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonDecrease(onClick: () -> Unit) {
    val size = 30.dp

    Button(
        onClick = onClick,
        modifier = Modifier.size(size)
    ) {
        Text(
            text = "-",
            fontSize = TextUnit(value = 30F, type = TextUnitType.Sp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonIncrease(onClick: () -> Unit) {
    val size = 30.dp

    Button(
        onClick = onClick,
        modifier = Modifier.size(size)
    ) {
        Text(
            text = "+",
            fontSize = TextUnit(value = 30F, type = TextUnitType.Sp),
            textAlign = TextAlign.Center
        )
    }
}