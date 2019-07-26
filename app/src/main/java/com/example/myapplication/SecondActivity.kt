package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandomNumber()
    }

    private val TOTAL_COUNT = "total_count"

    fun showRandomNumber(){

//        get the text view where the random number will be displayed
        val randomView:TextView = findViewById(R.id.textview_random)

//      get the textview where the heading is displayed
        val headingView:TextView = findViewById(R.id.textview_label)

//        get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

//        Generate random number
        val random = Random()
        var randomInt = 0
        if (count > 0)
            randomInt = random.nextInt(count)

//        Display the random number.
        randomView.setText(Integer.toString(randomInt))

//        substitute the max value into the string resource for the heading, and update heading
        headingView.setText(getString(R.string.random_heading, count))


    }
}
