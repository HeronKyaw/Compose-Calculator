package com.wunnakyaw.calculator.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wunnakyaw.calculator.ui.theme.DarkGrey
import com.wunnakyaw.calculator.ui.theme.Grey
import com.wunnakyaw.calculator.ui.theme.PurpleGrey40

@Composable
fun ResultPreviewScreen(
    modifier: Modifier = Modifier,
    result: String = ""
) {
    Text(
        text = result,
        fontWeight = FontWeight.Normal,
        fontSize = 35.sp,
        color = PurpleGrey40,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ResultPreviewScreenPreview() {
    ResultPreviewScreen(result = "3")
}