package com.example.morningzillahabbittracker.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import com.example.morningzillahabbittracker.R
import java.util.Locale

class FormData {
    var bodyWeight: Float by mutableFloatStateOf(70f)

    fun increaseBodyWeight() {
        this.bodyWeight += 0.01f
    }

    fun decreaseBodyWeight() {
        this.bodyWeight -= 0.01f
    }
}

@Composable
fun BodyWeight(navController: NavController) {
    var formData: FormData = FormData()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            InputSection(formData)
            Button(
                onClick = {}
            ) {
                Icon(
                    Icons.AutoMirrored.Rounded.ArrowForward,
                    "next"
                )
            }
//            WaistSizeSection(formData)
        }
    }
}

@Composable
fun InputSection(formData: FormData) {
    val bodyWeightStr = String.format(
        locale = Locale.US,
        format = "%.2f",
        formData.bodyWeight,
    )

    Column {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Text(text = stringResource(R.string.body_weight), textAlign = TextAlign.Center, fontSize = TextUnit(20F, TextUnitType.Sp))
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
                        formData.decreaseBodyWeight()
                    }
                )
                Text(
                    text = bodyWeightStr,
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
                        formData.increaseBodyWeight()
                    }
                )
            }
        }
    }
}

@Composable
fun ButtonDecrease(onClick: () -> Unit) {
    val size = 30.dp

    Button(
        onClick = onClick,
        modifier = Modifier.size(size).background(
            color = Color.Red
        )
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
        modifier = Modifier.size(size).background(
            color = Color.Green
        )
    ) {
        Text(
            text = "+",
            fontSize = TextUnit(value = 30F, type = TextUnitType.Sp),
            textAlign = TextAlign.Center
        )
    }
}