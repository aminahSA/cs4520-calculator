package com.cs4520.assignment3.mvvm

class MVVMModel {

    fun calculateResult(num1: Int, num2: Int, operation: String): Double {

        when (operation) {
            "addition" -> return (num1 + num2).toDouble()
            "subtraction" -> return (num1 - num2).toDouble()
            "multiplication" -> return (num1 * num2).toDouble()
            "division" -> if (num2 == 0) {
                //do nothing (yet)
            } else { return (num1.toDouble() / num2.toDouble())}
        }
        throw IllegalArgumentException("invalid operation.")
    }


}