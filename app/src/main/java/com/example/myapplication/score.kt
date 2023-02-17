package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [score.newInstance] factory method to
 * create an instance of this fragment.
 */
class score : Fragment() {

    private var x = 0;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _root = inflater.inflate(R.layout.fragment_score, container, false)
        //store score
        x = requireArguments().getInt("score")
        var sharedPref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        sharedPref.edit().putInt("score", x).apply()


        //back screen 2
        _root.findViewById<Button>(R.id.button6).setOnClickListener {
            val bundle = bundleOf("score" to x)
            findNavController().navigate(R.id.action_score_to_screen2,bundle)
        }
        //show score
        _root.findViewById<Button>(R.id.button5).setOnClickListener {
            _root.findViewById<TextView>(R.id.textView3).setText("the score of the last game is " + x.toString())
            _root.findViewById<TextView>(R.id.textView3).gravity
        }


        return _root

    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}