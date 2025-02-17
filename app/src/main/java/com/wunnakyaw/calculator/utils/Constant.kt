package com.wunnakyaw.calculator.utils

import com.wunnakyaw.calculator.data.models.OperationModel


val operations: List<OperationModel> = listOf(
    OperationModel("AC", ButtonActionType.CLEAR),
    OperationModel("DEL", ButtonActionType.DELETE),
    OperationModel("%", ButtonActionType.OPERATION),
    OperationModel("÷", ButtonActionType.OPERATION),
    OperationModel("7"),
    OperationModel("8"),
    OperationModel("9"),
    OperationModel("×", ButtonActionType.OPERATION),
    OperationModel("4"),
    OperationModel("5"),
    OperationModel("6"),
    OperationModel("-", ButtonActionType.OPERATION),
    OperationModel("1"),
    OperationModel("2"),
    OperationModel("3"),
    OperationModel("+", ButtonActionType.OPERATION),
    OperationModel(".00"),
    OperationModel("0"),
    OperationModel("."),
    OperationModel("=", ButtonActionType.OPERATION),
)