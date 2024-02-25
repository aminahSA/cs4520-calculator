package com.cs4520.assignment3.mvp

interface MVPContract {

    // interface for the View
    interface View {

        // give the operation button clicked to the presenter including input
        fun notifyOperationClicked();

        // display a toast message if inputs are invalid according to info from presenter
        fun showInvalidInputError();

        // display the result given from the presenter
        fun displayResult(result: Double);
        }


    // interface for the Presenter
    interface Presenter {

        //accept input from the view
            // if valid input, pass to the model
            // if invalid input (1 or 0 numbers; letters), tell view to display error message
        fun acceptInput(input1: String, input2: String, operation: String);

        // accept valid result from model and give to view
        fun giveResult();
    }

    // interface for the Model
    interface Model {

        // accept 2 numbers from presenter and calculate result, then give to presenter
        fun calculateResult(num1: Int, num2: Int, operation: String): Double
        }
}