package com.wunnakyaw.calculator.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.wunnakyaw.calculator.utils.ButtonActionType
import com.wunnakyaw.calculator.utils.CalculateUtils
import com.wunnakyaw.calculator.utils.operations

class CalculatorViewModel: ViewModel() {
    private var _expression = mutableStateOf("0")
    val expression: MutableState<String>
        get() = _expression

    private var _prevExpression = mutableStateOf("")
    val prevExpression: MutableState<String>
        get() = _prevExpression

    // Filter the operations list to get only the operators
    private val operatorsList: List<String> = operations.filter {
        it.type == ButtonActionType.OPERATION
    }.map {
        it.value
    }

    private val delimiter: String = " "

//    private val prioritizeOperators: List<String> = listOf("x", "÷", "%")

    fun onButtonClicked(button: String) {
        _prevExpression.value = ""
        _expression.value = if (_expression.value == "0") {
            button
        } else if (operatorsList.contains(button)) {
            if (operatorsList.contains(_expression.value.last().toString())) {
             _expression.value.dropLast(1) + delimiter + button
            } else {
                _expression.value + delimiter + button
            }
        } else {
            if (operatorsList.contains(_expression.value.last().toString())) {
                _expression.value + delimiter + button
            } else {
                _expression.value + button
            }
        }
    }

    fun onClearClicked(isAll: Boolean) {
        if (isAll) {
            _expression.value = "0"
            _prevExpression.value = "0"
        } else {
            _expression.value = if (_expression.value.length == 1) {
                "0"
            } else {
                _expression.value.dropLast(1)
            }
        }
    }

    fun onEqualClicked() {
        _prevExpression.value = _expression.value
        calculate(_expression.value)
    }

    private fun calculate(expression: String) {
        val expressionString: String = expression

        val expressionList: List<String> = expressionString.split(delimiter)
        val mutableExpression = expressionList.toMutableList()

        var firstNumber = ""
        var secondNumber = ""
        var currentOperator = ""

        var startIndex = 0
        var endIndex = 0

        var i = 0

        while (mutableExpression.size > 1) {
            val index = i
            val value = mutableExpression[i]
            if (operatorsList.contains(value)) {
                currentOperator = value
            } else {
                if (currentOperator.isEmpty()) {
                    startIndex = index
                    firstNumber = value
                } else {
                    endIndex = index
                    secondNumber = value
                }
            }

            if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
                val result = when (currentOperator) {
                    "+" -> CalculateUtils.add(firstNumber.toDouble(), secondNumber.toDouble())
                    "-" -> CalculateUtils.subtract(firstNumber.toDouble(), secondNumber.toDouble())
                    "x" -> CalculateUtils.multiply(firstNumber.toDouble(), secondNumber.toDouble())
                    "÷" -> CalculateUtils.divide(firstNumber.toDouble(), secondNumber.toDouble())
                    "%" -> CalculateUtils.modulus(firstNumber.toDouble(), secondNumber.toDouble())
                    else -> 0.0
                }

                // clear value after calculation
                firstNumber = ""
                secondNumber = ""
                currentOperator = ""

                // remove the first number, second number and operator from the expression and replace it with the result
                mutableExpression.subList(startIndex, endIndex + 1).clear()
                mutableExpression.add(startIndex, result.toString())
                i = 0
            } else {
                i++
            }
        }

        _expression.value = mutableExpression.joinToString(delimiter)
    }
}