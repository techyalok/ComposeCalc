package com.alok.composecalculator

sealed class CalculatorAction {
    data class Number(val num: Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    object Decimal : CalculatorAction()
    object Ans : CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
}