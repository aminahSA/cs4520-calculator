package com.cs4520.assignment3.mvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.cs4520.assignment3.R

// TODO: Implement toast message for invalid or missing inputs
// TODO: clear inputs after clicking any operation

class MVPFragment : Fragment(), MVPContract.View {

private lateinit var presenter: MVPContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val model = MVPModel()
        presenter = MVPPresenter(this, model)


        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_mvp, container, false)

        //retrieve text fields
        val input1 = rootview.findViewById<EditText>(R.id.mvpInput1)
        val input2 = rootview.findViewById<EditText>(R.id.mvpInput2)

        return rootview
    }

    // give the operation button clicked to the presenter including input
    override fun notifyOperationClicked() {
       // val userInput = editText.text.toString()
     //   presenter.acceptInput()
    }

    // display a toast message if inputs are invalid according to info from presenter

    override fun showInvalidInputError() {
        TODO("Not yet implemented")
    }

    // display the result given from the presenter
    override fun displayResult(result: Double) {
        TODO("Not yet implemented")
    }

}