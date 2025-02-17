package com.wunnakyaw.calculator.data.models

import com.wunnakyaw.calculator.utils.ButtonActionType

data class OperationModel(
    val value: String,
    val type: ButtonActionType = ButtonActionType.DEFAULT,
)