package com.hsae.belus

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import android.util.Log
import java.io.DataOutputStream


class AutoService:Service() {
    private val mNotificationManager: NotificationManager by lazy {
        getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }
    private val ms=MicroService()
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    private fun sendNotification16(){
        @Suppress("DEPRECATION")
        val nf=Notification.Builder(applicationContext)
                .setContentText("test service for passandr")
                .setContentTitle("Belus")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher))
                .setAutoCancel(false)
                .build()
        startForeground(1,nf)
    }
    @TargetApi(Build.VERSION_CODES.O)
    private fun sendNotification26(){
        val id="channel_1"
        val description="123"
        val importance= NotificationManager.IMPORTANCE_LOW
        val mChannel= android.app.NotificationChannel(id,description,importance)
        mNotificationManager.createNotificationChannel(mChannel)
        val nf=Notification.Builder(applicationContext,id)
                .setContentText("自动化测试工具")
                .setContentTitle("Belus")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher))
                .setAutoCancel(false)
                .build()
        //mNotificationManager.notify(1,nf)
        startForeground(1,nf)
    }
    private fun sendNotification(){
        if(Build.VERSION.SDK_INT>26){
            Log.i("Belus","api26")
            sendNotification26()
        }else{
            Log.i("Belus","api16")
            sendNotification16()
        }
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("Command","test!!!!")
        sendNotification()
        ms.createServer(8009)

        return super.onStartCommand(intent, flags, startId)
    }
}