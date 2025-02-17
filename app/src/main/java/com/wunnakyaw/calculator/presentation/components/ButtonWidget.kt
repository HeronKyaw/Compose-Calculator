package com.wunnakyaw.calculator.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wunnakyaw.calculator.ui.theme.PurpleGrey40
import com.wunnakyaw.calculator.ui.theme.White

@Composable
fun ButtonWidget(
    modifier: Modifier = Modifier,
    text: String,
    buttonColor: Color = PurpleGrey40,
    onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick() },
        modifier = Modifier
            .clip(RoundedCornerShape(30))
            .height(100.dp)
            .width(100.dp)
            .background(color = buttonColor)
    ) {
        Text(
            text = text,
            fontSize = 30.sp,
            color = White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonWidgetPreview() {
    ButtonWidget(text = "1", onClick = {})
}