package com.example.lab52

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {

            Toast.makeText(context, "Device boot completed!", Toast.LENGTH_LONG).show()
            Log.d("BootCompletedReceiver", "Device boot completed!")
        }
    }
}
