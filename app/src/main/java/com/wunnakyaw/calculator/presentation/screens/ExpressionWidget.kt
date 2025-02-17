package com.wunnakyaw.calculator.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ExpressionWidget(
    modifier: Modifier = Modifier,
    expression: MutableState<String>
) {
    val fontSize: TextUnit = when {
        expression.value.length > 15 -> 30.sp
        expression.value.length > 10 -> 40.sp
        else -> 50.sp
    }
    Text(
        text = expression.value,
        fontWeight = FontWeight.Medium,
        fontSize = fontSize,
        letterSpacing = 1.sp,
        textAlign = TextAlign.End,
        modifier = modifier
    )
}