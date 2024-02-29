package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVVMViewModel: ViewModel() {

    // creating object of Model class
    private val model: MVVMModel = MVVMModel()

    //create variable for error message
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    // fields for inputs
    private val _userInput1 = MutableLiveData<String>()
    val userInput1: LiveData<String> = _userInput1

    private val _userInput2 = MutableLiveData<String>()
    val userInput2: LiveData<String> = _userInput2

    // field for the result
    private val _result = MutableLiveData<Double>()
    val result: LiveData<Double> = _result


    // Perform addition and update the result LiveData
    fun add(num1: Int?, num2: Int?, op: String) {
        if (num1 !is Int || num2 !is Int) {
            updateMessage("invalid input.")
            clearInputs()
        } else {
            _result.value = model.calculateResult(num1, num2, op)
            clearInputs()
        }
    }

    // Perform subtraction and update the result LiveData
    fun subtract(num1: Int?, num2: Int?, op: String) {
        if (num1 !is Int || num2 !is Int) {
            updateMessage("invalid input.")
            clearInputs()
        } else {
            _result.value = model.calculateResult(num1, num2, op)
            clearInputs()
        }
    }

    // Perform multiplication and update the result LiveData
    fun multiply(num1: Int?, num2: Int?, op: String) {
        if (num1 !is Int || num2 !is Int) {
            updateMessage("invalid input.")
            clearInputs()
        } else {
            _result.value = model.calculateResult(num1, num2, op)
            clearInputs()
        }    }

    // Perform division and update the result LiveData
    fun divide(num1: Int?, num2: Int?, op: String) {
        if (num1 !is Int || num2 !is Int) {
            updateMessage("invalid input.")
            clearInputs()
        } else {
            try {_result.value = model.calculateResult(num1, num2, op)
                clearInputs()} catch (e: Exception) {
                e.message?.let { updateMessage(it)
                    clearInputs()}
            }
        }
    }

    // Function to update the error message
    private fun updateMessage(newMessage: String) {
        _message.value = newMessage
    }

    //clear inputs
    private fun clearInputs() {
        _userInput1.value = ""
        _userInput2.value = ""
    }

}