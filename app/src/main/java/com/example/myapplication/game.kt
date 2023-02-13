package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [game.newInstance] factory method to
 * create an instance of this fragment.
 */
class game : Fragment() {
    var num = 0
    var counts = 0
    var wait:Long = 3000
    var cuttime:Long = 60000
    lateinit var _root:View ;
    lateinit var sheepView:ImageView ;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _root = inflater.inflate(R.layout.fragment_game, container, false)

        sheepView = _root.findViewById<ImageView>(R.id.sheepView)

        _root.findViewById<Button>(R.id.button7).setOnClickListener {
            _root.findViewById<Button>(R.id.button8).isVisible = false
            _root.findViewById<Button>(R.id.button7).isVisible = false
            _root.findViewById<Button>(R.id.sheepView).isVisible = false
            num = (0..10).random()
            //handler.post(runnable)
            counts = num
            countDownTimer.start()
            _root.findViewById<Button>(R.id.button7).text=num.toString()

        }
        _root.findViewById<Button>(R.id.button8).setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.setType("image/*");
            //sheepView.setImageURI("")

        }
        return _root

    }

    suspend fun mysimple(x:Int,y:Int,zx:Int,zy:Int,num:Int,sheepView:ImageView,btn:Button){
        for (i in 0..num) {
            sheepView.x = (zx..x- zx).random().toFloat()
            sheepView.y = (zy..y-zy).random().toFloat()
            btn.text=i.toString()
            delay(200)
        }
    }
    private val handler: Handler = Handler()
    private var count = 0

    private val runnable: Runnable = object : Runnable {
        override fun run() {
            var xvalue = _root.width
            var yvalue = _root.height
            var sheepx = sheepView.width
            var sheepy = sheepView.height
            var vx = (5 ..30).random()
            for (i in 0..num){
                sheepView.x = (sheepx..xvalue- sheepx).random().toFloat()
                sheepView.y = (sheepy..yvalue-sheepy).random().toFloat()
                handler.postDelayed(this, vx.toLong())
            }
            //findNavController().navigate(R.id.action_game_to_calculate,bundle)
        }
    }
    private val runnable2: Runnable = object : Runnable {
        override fun run() {
            val bundle = bundleOf("score" to num)
            findNavController().navigate(R.id.action_game_to_calculate,bundle)
        }
    }

    private val countDownTimer = object : CountDownTimer(60000, 1000) {

        override fun onTick(millisUntilFinished: Long) {
            // Update UI here if needed
            if(counts>0){
                println(counts)
                if(wait <= cuttime-millisUntilFinished){
                    println("update")
                    _root.findViewById<Button>(R.id.sheepView).isVisible = true
                    sheepView.x = (sheepView.width.._root.width- sheepView.width).random().toFloat()
                    sheepView.y = (sheepView.height.._root.height-sheepView.height).random().toFloat()
                    counts--
                    wait = ((5 ..30).random()*100).toLong()
                    cuttime = millisUntilFinished
                }

            }

        }

        override fun onFinish() {
            // Navigate to the next screen
            val bundle = bundleOf("score" to num)
            findNavController().navigate(R.id.action_game_to_calculate,bundle)
        }
    }
    /*
    private val runnable: Runnable = object : Runnable {
        override fun run() {
            count++
            var xvalue = _root.width
            var yvalue = _root.height
            var sheepx = sheepView.width
            var sheepy = sheepView.height
            sheepView.x = (sheepx..xvalue- sheepx).random().toFloat()
            sheepView.y = (sheepy..yvalue-sheepy).random().toFloat()
            // Update UI here
            if (count < num) {
                handler.postDelayed(this, 1000)
            } else {
                //findNavController().graph.addArgument("bundle",5)
                x = true;
            }
        }
    }*/
    override fun onDestroyView() {
        super.onDestroyView()
    }
    fun game(){
        num = (0..10).random()
        for (i in 0..num){
            //sheep display
        }
        findNavController().navigate(R.id.action_game_to_calculate)
    }
}