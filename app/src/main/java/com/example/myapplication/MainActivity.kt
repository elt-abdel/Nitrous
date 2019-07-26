package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View) {
        // Toast myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(
            this, "Hello Rosey!",
            Toast.LENGTH_SHORT
        )
        myToast.show()
    }

    fun countMe (view: View){
//        get the text view
        val showCountTextView: TextView =  findViewById(R.id.textView)

//        get the value of the text view.
        val countString = showCountTextView.text.toString()

//        convert value to a number and increment it

        var count = parseInt(countString);
        count++

//        Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }

    private val TOTAL_COUNT = "total_count"

    fun randomMe (view: View){
// Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

//        Get the text view that shows the count.
        val showCountTextView : TextView = findViewById(R.id.textView)

//        get the value of the text view
        val countString = showCountTextView.text.toString()

//        convert the count to an int
        val count = parseInt(countString)

//        add the count to the extras for the intent.
        randomIntent.putExtra(TOTAL_COUNT, count)

// Start the new activity.
        startActivity(randomIntent)

    }
}
