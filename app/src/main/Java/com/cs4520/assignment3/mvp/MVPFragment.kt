package com.cs4520.assignment3.mvp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.cs4520.assignment3.R

class MVPFragment : Fragment(), MVPContract.View{

    private lateinit var presenter: MVPContract.Presenter
    private lateinit var userInput1: String
    private lateinit var userInput2: String
    private lateinit var field1: EditText
    private lateinit var field2: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val model = MVPModel()
        presenter = MVPPresenter(this, model)
        userInput1 = ""
        userInput2 = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_mvp, container, false)

        //retrieve text fields
        field1 = rootView.findViewById(R.id.mvpInput1)
        field2 = rootView.findViewById(R.id.mvpInput2)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextListeners()
        notifyOperationClicked()
    }

    //set the text listeners to update the text fields whenever changed
    private fun setTextListeners() {
        field1.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userInput1 = s.toString()
            }
            override fun afterTextChanged(s: Editable?) {}
        })
        field2.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                userInput2 = s.toString()
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // listen for the operation buttons clicked and give info to the presenter
   override fun notifyOperationClicked() {
        view?.findViewById<ImageButton>(R.id.add_button)?.setOnClickListener {
            presenter.acceptInput(userInput1, userInput2, "addition")
        }
        view?.findViewById<ImageButton>(R.id.sub_button)?.setOnClickListener {
            presenter.acceptInput(userInput1, userInput2, "subtraction")
        }
        view?.findViewById<ImageButton>(R.id.mult_button)?.setOnClickListener {
            presenter.acceptInput(userInput1, userInput2, "multiplication")
        }
        view?.findViewById<ImageButton>(R.id.div_button)?.setOnClickListener {
            presenter.acceptInput(userInput1, userInput2, "division")
        }
  }


    // display a toast message if inputs are invalid according to info from presenter
  override fun showInvalidInputError() {
        Toast.makeText(requireContext(), "Invalid input.", Toast.LENGTH_SHORT).show()
    }

    // display the result given from the presenter
    override fun displayResult(result: Double) {
        view?.findViewById<TextView>(R.id.the_result)?.text = result.toString()
   }
}