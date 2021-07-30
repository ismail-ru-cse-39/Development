package com.example.mvctestprojet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.util.*


class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    var myModel: Model? = null
    var button1: Button? = null
    var button2: Button? = null
    var button3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // creating relationship between the
        // observable Model and the
        // observer Activity
        myModel = Model()
        myModel!!.addObserver(this)

        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        // transfer the control to Onclick() method
        button1?.setOnClickListener(this)
        button2?.setOnClickListener(this)
        button3?.setOnClickListener(this)


    }

    // calling setValueAtIndex() method
    // by passing appropriate arguments
    // for different buttons
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button -> myModel?.setValueAtIndex(0)
            R.id.button2 -> myModel?.setValueAtIndex(1)
            R.id.button3 -> {
                Log.i("ismail","Button 3 pressed")
                myModel?.setValueAtIndex(2)
            }
        }
    }

    // function to update the view after
    // the values are modified by the model
    override fun update(o: Observable?, arg: Any?) {
        button1!!.text = "Count: " + myModel!!.getValueAtIndex(0)
        button2!!.text = "Count: " + myModel!!.getValueAtIndex(1)
        button3!!.text = "Count: " + myModel!!.getValueAtIndex(2)
    }
}