package com.alok.composecalculator

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf( CalculatorState())
        private set

    fun onAction(action: CalculatorAction){
        when(action){
            is CalculatorAction.Number -> enterNumber(action.num)
            is CalculatorAction.Clear -> state = CalculatorState() //Again initial state
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Ans -> answerEvalution()
            is CalculatorAction.Operation -> enterOperation(action.operation)
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
       if(state.number1.isNotBlank()){
           state = state.copy(operation = operation)
       }
    }

    private fun answerEvalution() {
        val num1 = state.number1.toDoubleOrNull() //Parses the string as a Double number and returns the result or null if the string is not a valid representation of a number.
        val num2 = state.number2.toDoubleOrNull()
        if (num1 != null && num2 != null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> num1 + num2
                is CalculatorOperation.Subtract -> num1 - num2
                is CalculatorOperation.Multiply -> num1 * num2
                is CalculatorOperation.Divide -> num1 / num2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),  //take first 15 digits of result
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterDecimal() {
        if (state.number1.isNotBlank() && state.operation==null && !state.number1.contains(".")){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        else if (state.number2.isNotBlank() && !state.number2.contains(".")){
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun performDeletion() {
       when{
           state.number2.isNotBlank() -> state.copy(
                                         number2 = state.number2.dropLast(1)
                                            )
           state.operation != null -> state.copy(
                                        operation = null
                                         )
           state.number1.isNotBlank() -> state.copy(
                                              number1 = state.number1.dropLast(1)
                                            )
       }
    }

    private fun enterNumber(num: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + num
            )
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + num
        )
    }
    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

