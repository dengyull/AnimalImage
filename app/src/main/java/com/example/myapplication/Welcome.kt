package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [Welcome.newInstance] factory method to
 * create an instance of this fragment.
 */
class Welcome : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _root = inflater.inflate(R.layout.fragment_welcome, container, false)
        _root.findViewById<Button>(R.id.btn_ok).setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_screen2)
        }
        return _root

    }



    override fun onDestroyView() {
        super.onDestroyView()
    }
}