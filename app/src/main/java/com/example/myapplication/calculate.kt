package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [calculate.newInstance] factory method to
 * create an instance of this fragment.
 */
class calculate : Fragment() {
    private var x = 0;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _root = inflater.inflate(R.layout.fragment_calculate, container, false)
        //x = arguments?.getInt("score", 5)
        x = requireArguments().getInt("score")
        _root.findViewById<TextView>(R.id.textView4).text = _root.findViewById<TextView>(R.id.textView4).text.toString() + " Hint: " + x.toString()
        _root.findViewById<Button>(R.id.btn_sure).setOnClickListener {
            var ans = _root.findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
            var ass = ans.toInt()
            var sco = 0
            if (ass < x){
                 sco = (ass * 100 / x)
            } else {
                sco = ( (2 * x - ass)  * 100 / x)
            }


            val bundle = bundleOf("score" to sco)
            findNavController().navigate(R.id.action_calculate_to_score,bundle)
        }


        return _root

    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

}