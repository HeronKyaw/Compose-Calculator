package com.wunnakyaw.calculator.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wunnakyaw.calculator.data.models.OperationModel
import com.wunnakyaw.calculator.presentation.components.ButtonWidget
import com.wunnakyaw.calculator.presentation.components.CustomGrid
import com.wunnakyaw.calculator.ui.theme.DarkGrey
import com.wunnakyaw.calculator.ui.theme.Orange
import com.wunnakyaw.calculator.ui.theme.PurpleGrey40

@Composable
fun ButtonGridScreen(modifier: Modifier = Modifier) {
    val operationColour: Color = Orange
    val numberColor: Color = PurpleGrey40

    val operations: List<OperationModel> = listOf(
        OperationModel("AC", numberColor),
        OperationModel("DEL", numberColor),
        OperationModel("%", numberColor),
        OperationModel("÷", operationColour),
        OperationModel("7", numberColor),
        OperationModel("8", numberColor),
        OperationModel("9", numberColor),
        OperationModel("×", operationColour),
        OperationModel("4", numberColor),
        OperationModel("5", numberColor),
        OperationModel("6", numberColor),
        OperationModel("-", operationColour),
        OperationModel("1", numberColor),
        OperationModel("2", numberColor),
        OperationModel("3", numberColor),
        OperationModel("+", operationColour),
        OperationModel(".00", numberColor),
        OperationModel("0", numberColor),
        OperationModel(".", numberColor),
        OperationModel("=", operationColour),
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .background(color = DarkGrey)
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        CustomGrid(
            columns = 4,
            itemCount = operations.size,
            modifier = modifier
        ) { index ->
            ButtonWidget(
                text = operations[index].value,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                buttonColor = operations[index].buttonColor,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonGridScreenPreview() {
    ButtonGridScreen()
}