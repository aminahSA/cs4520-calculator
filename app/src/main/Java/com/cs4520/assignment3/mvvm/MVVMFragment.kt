package com.cs4520.assignment3.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cs4520.assignment3.R
import com.cs4520.assignment3.databinding.FragmentMvvmBinding


class MVVMFragment: Fragment() {

    private lateinit var myMVVMViewModel: MVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentMvvmBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_mvvm, container, false)

        myMVVMViewModel = ViewModelProvider(this)[MVVMViewModel::class.java]

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the result LiveData in the ViewModel
        myMVVMViewModel.result.observe(viewLifecycleOwner) { result ->
            // Update the TextView's text when the LiveData value changes
            view.findViewById<TextView>(R.id.the_result).text = result.toString()
        }

        myMVVMViewModel.userInput1.observe(viewLifecycleOwner) { userInput1 ->
                view.findViewById<EditText>(R.id.editTextNumber).setText(userInput1)
        }

        myMVVMViewModel.userInput2.observe(viewLifecycleOwner) { userInput2 ->
            view.findViewById<EditText>(R.id.editTextNumber2).setText(userInput2)
        }


        view.findViewById<ImageButton>(R.id.add_button)?.setOnClickListener {
            // Get the text from the EditText views
            val editTextNumber1 = view.findViewById<EditText>(R.id.editTextNumber)
            val editTextNumber2 = view.findViewById<EditText>(R.id.editTextNumber2)
            val input1Text = editTextNumber1.text.toString()
            val input2Text = editTextNumber2.text.toString()

            // Convert the text to integers
            val input1 = input1Text.toIntOrNull() ?: 0
            val input2 = input2Text.toIntOrNull() ?: 0
            myMVVMViewModel.add(input1, input2, "addition")
        }

        view.findViewById<ImageButton>(R.id.sub_button)?.setOnClickListener {
            // Get the text from the EditText views
            val editTextNumber1 = view.findViewById<EditText>(R.id.editTextNumber)
            val editTextNumber2 = view.findViewById<EditText>(R.id.editTextNumber2)
            val input1Text = editTextNumber1.text.toString()
            val input2Text = editTextNumber2.text.toString()

            // Convert the text to integers
            val input1 = input1Text.toIntOrNull() ?: 0
            val input2 = input2Text.toIntOrNull() ?: 0
            myMVVMViewModel.subtract(input1, input2, "subtraction")
        }

        view.findViewById<ImageButton>(R.id.mult_button)?.setOnClickListener {
            // Get the text from the EditText views
            val editTextNumber1 = view.findViewById<EditText>(R.id.editTextNumber)
            val editTextNumber2 = view.findViewById<EditText>(R.id.editTextNumber2)
            val input1Text = editTextNumber1.text.toString()
            val input2Text = editTextNumber2.text.toString()

            // Convert the text to integers
            val input1 = input1Text.toIntOrNull() ?: 0
            val input2 = input2Text.toIntOrNull() ?: 0
            myMVVMViewModel.multiply(input1, input2, "multiplication")
        }

        view.findViewById<ImageButton>(R.id.div_button)?.setOnClickListener {
            // Get the text from the EditText views
            val editTextNumber1 = view.findViewById<EditText>(R.id.editTextNumber)
            val editTextNumber2 = view.findViewById<EditText>(R.id.editTextNumber2)
            val input1Text = editTextNumber1.text.toString()
            val input2Text = editTextNumber2.text.toString()

            // Convert the text to integers
            val input1 = input1Text.toIntOrNull() ?: 0
            val input2 = input2Text.toIntOrNull() ?: 0
            myMVVMViewModel.divide(input1, input2, "division")
        }
    }

    fun showToast(message: String) {

    }
}