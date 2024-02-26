package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel: ViewModel() {

    // creating object of Model class
    private val model: MVVMModel = MVVMModel()

    // fields for inputs
    private val _userInput1 = MutableLiveData<String>()
    val userInput1: LiveData<String> = _userInput1

    private val _userInput2 = MutableLiveData<String>()
    val userInput2: LiveData<String> = _userInput2

    // field for the result
    private val _result = MutableLiveData<Double>()
    val result: LiveData<Double> = _result


    // Perform addition and update the result LiveData
    fun add(num1: Int, num2: Int, op: String) {
        _result.value = model.calculateResult(num1, num2, op)
    }

    // Perform subtraction and update the result LiveData
    fun subtract(num1: Int, num2: Int, op: String) {
        _result.value = model.calculateResult(num1, num2, op)
    }

    // Perform multiplication and update the result LiveData
    fun multiply(num1: Int, num2: Int, op: String) {
        _result.value = model.calculateResult(num1, num2, op)
    }

    // Perform division and update the result LiveData
    fun divide(num1: Int, num2: Int, op: String) {
            _result.value = model.calculateResult(num1, num2, op)
            // display an error message to the user
            // You can use another LiveData to hold error messages and observe it in the Fragment
            // Alternatively, you can use Toast to display the error message
    }

}