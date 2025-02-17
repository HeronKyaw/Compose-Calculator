package com.wunnakyaw.calculator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wunnakyaw.calculator.presentation.screens.ButtonGridScreen
import com.wunnakyaw.calculator.presentation.screens.ExpressionPreviewScreen
import com.wunnakyaw.calculator.presentation.screens.ResultPreviewScreen

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.End,
        ) {
            ExpressionPreviewScreen(
                expression = "1+2",
            )
            ResultPreviewScreen(
                result = "3",
            )
        }
        ButtonGridScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun CalculatorPreviewScreen() {
    CalculatorScreen()
}