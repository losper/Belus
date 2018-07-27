package com.hsae.belus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AutoStart: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("Belus","AutoStart")
        val itt = Intent(context, AutoService().javaClass)
        context?.startService(itt)
    }
}