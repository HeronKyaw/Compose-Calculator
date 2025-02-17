package com.wunnakyaw.calculator.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExpressionPreviewScreen(
    modifier: Modifier = Modifier,
    expression: String = ""
) {
    Text(
        text = expression,
        fontWeight = FontWeight.Medium,
        fontSize = 50.sp,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ExpressionPreviewScreenPreview() {
    ExpressionPreviewScreen(expression = "1+2")
}