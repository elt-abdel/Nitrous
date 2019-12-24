package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.PermissionChecker
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity(), LocationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lm =
            this.getSystemService(Context.LOCATION_SERVICE) as LocationManager

//        check for permission access
//        then we request update as frequently as possible

        if (PermissionChecker.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION) == PermissionChecker.PERMISSION_GRANTED) {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this)

            onLocationChanged(null)
        }
    }

//    count up
    fun countUp (view: View){
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

//    count down
    fun countDown (view: View){
//        get the text view
        val showCountTextView: TextView =  findViewById(R.id.textView)

//        get the value of the text view.
        val countString = showCountTextView.text.toString()

//        convert value to a number and increment it

        var count = parseInt(countString);
        count--

//        Display the new value in the text view.
        showCountTextView.setText(count.toString());
    }

    private val TOTAL_COUNT = "total_count"


    //    locating and changing the text view with the correct speed

    override fun onLocationChanged(location: Location?) {

        val SpeedTextView: TextView =  findViewById(R.id.curSpeedView)

        if( location == null ){
            SpeedTextView.setText("--.-- m/s");
        }
        else{
            val nCurrentSpeed = location.getSpeed();
            SpeedTextView.setText("$nCurrentSpeed m/s")
        }
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // TO DO:
//    add set button,
//    connect music playlist,
//    based on speed difference from target goal, play different kind os sub playlist


}
