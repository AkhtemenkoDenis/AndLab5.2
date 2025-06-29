package com.example.lab52

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var airplaneStatusText: TextView

    private val powerConnectedReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == Intent.ACTION_POWER_CONNECTED) {
                Toast.makeText(context, "Power Connected!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val airplaneModeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
                val isAirplaneModeOn = intent.getBooleanExtra("state", false)
                airplaneStatusText.text = if (isAirplaneModeOn)
                    "Airplane Mode: ON"
                else
                    "Airplane Mode: OFF"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        airplaneStatusText = findViewById(R.id.text_airplane_status)
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(powerConnectedReceiver, IntentFilter(Intent.ACTION_POWER_CONNECTED))
        registerReceiver(airplaneModeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(powerConnectedReceiver)
        unregisterReceiver(airplaneModeReceiver)
    }
}
