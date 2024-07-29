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
           state = state.copy(operation= operation)
       }
    }

    private fun answerEvalution() {
        TODO("Not yet implemented")
    }

    private fun enterDecimal() {
        if (state.number1.isNotBlank() && state.operation==null && !state.number1.contains(".")){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (state.number2.isNotBlank() && !state.number2.contains(".")){
            state = state.copy(
                number1 = state.number2 + "."
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
        TODO("Not yet implemented")
    }
}