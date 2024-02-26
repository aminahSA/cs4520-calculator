package com.cs4520.assignment3.mvp

class MVPModel: MVPContract.Model {

    // accept 2 numbers from presenter and calculate result, then give to presenter
    override fun calculateResult(num1: Int, num2: Int, operation: String): Double {

        when (operation) {
            "addition" -> return (num1 + num2).toDouble()
            "subtraction" -> return (num1 - num2).toDouble()
            "multiplication" -> return (num1 * num2).toDouble()
            "division" -> return (num1.toDouble() / num2.toDouble())
        }
        return 0.0
    //throw IllegalArgumentException("invalid operation.")
    }
}