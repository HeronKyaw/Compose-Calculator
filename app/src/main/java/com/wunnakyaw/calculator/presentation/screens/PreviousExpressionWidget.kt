package com.wunnakyaw.calculator.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.wunnakyaw.calculator.ui.theme.PurpleGrey40

@Composable
fun PreviousExpressionWidget(
    modifier: Modifier = Modifier,
    result: MutableState<String>
) {
    Text(
        text = result.value,
        fontWeight = FontWeight.Normal,
        fontSize = 35.sp,
        color = PurpleGrey40,
        modifier = modifier
    )
}