package com.wunnakyaw.calculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wunnakyaw.calculator.presentation.components.ButtonWidget
import com.wunnakyaw.calculator.presentation.components.CustomGrid
import com.wunnakyaw.calculator.presentation.screens.ExpressionWidget
import com.wunnakyaw.calculator.presentation.screens.PreviousExpressionWidget
import com.wunnakyaw.calculator.ui.theme.DarkGrey
import com.wunnakyaw.calculator.ui.theme.Orange
import com.wunnakyaw.calculator.ui.theme.PurpleGrey40
import com.wunnakyaw.calculator.utils.ButtonActionType
import com.wunnakyaw.calculator.utils.operations

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = CalculatorViewModel(),
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
            PreviousExpressionWidget(
                result = viewModel.prevExpression,
            )
            ExpressionWidget(
                expression = viewModel.expression,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                .background(color = DarkGrey)
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            CustomGrid(
                columns = 4,
                itemCount = operations.size,
            ) { index ->
                ButtonWidget(
                    text = operations[index].value,
                    buttonColor = if (operations[index].type == ButtonActionType.OPERATION) Orange else PurpleGrey40,
                    onClick = {
                        when (operations[index].type) {
                            ButtonActionType.CLEAR -> {
                                viewModel.onClearClicked(true)
                            }
                            ButtonActionType.DELETE -> {
                                viewModel.onClearClicked(false)
                            }
                            else -> {
                                if (operations[index].type == ButtonActionType.OPERATION && operations[index].value == "=") {
                                    viewModel.onEqualClicked()
                                } else {
                                    viewModel.onButtonClicked(operations[index].value)
                                }
                            }
                        }
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CalculatorPreviewScreen() {
    CalculatorScreen()
}