package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [screen2.newInstance] factory method to
 * create an instance of this fragment.
 */
class screen2 : Fragment() {

    private var x = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _root = inflater.inflate(R.layout.fragment_screen2, container, false)
        _root.findViewById<Button>(R.id.button4).setOnClickListener {
            findNavController().navigate(R.id.action_screen2_to_welcome)
            //_root.findViewById<Button>(R.id.button4).setText("s")
        }
        x = requireArguments().getInt("score")
        _root.findViewById<Button>(R.id.button2).setOnClickListener {
            findNavController().navigate(R.id.action_screen2_to_game)
        }
        _root.findViewById<Button>(R.id.button3).setOnClickListener {
            _root.findViewById<TextView>(R.id.textView2).setText("the score of the last game is " + x.toString())
            _root.findViewById<TextView>(R.id.textView2).gravity
        }
        return _root

    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}