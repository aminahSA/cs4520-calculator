package com.cs4520.assignment3.mvp

class MVPPresenter(private val view: MVPFragment, private val model : MVPModel): MVPContract.Presenter {

    //accept input from the view
    // if valid input, pass to the model
    // if invalid input (1 or 0 numbers; letters), tell view to display error message //do not allow 0 divisor
    override fun acceptInput(input1: String, input2: String, operation: String) {

        val num1 = input1.toIntOrNull()
        val num2 = input2.toIntOrNull()

        // Input is a valid number
        if (num1 != null && num2 != null) {
            if (!(num2 == 0 && operation == "division")) {
                // Send numbers to model to calculate the result
                val result = model.calculateResult(num1, num2, operation)
                view.displayResult(result)
            } else {
                //Input is not a valid number
                view.showInvalidInputError()
            }
        } else {
             //Input is not a valid number
            view.showInvalidInputError()
        }
    }

    // accept valid result from model and give to view
    override fun giveResult() {

   }

}