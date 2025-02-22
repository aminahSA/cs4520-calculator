package com.cs4520.assignment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navToMvp()
        navToMvvm()
    }

private fun navToMvp () {
    view?.findViewById<Button>(R.id.mvp_button)?.setOnClickListener {
        findNavController().navigate(R.id.action_homeFragment_to_mvpFragment)
    }
}

    private fun navToMvvm () {
        view?.findViewById<Button>(R.id.mvvm_button)?.setOnClickListener {
            findNavController().navigate(R.id.action_home_Fragment_to_MVVMFragment)
        }
    }
}