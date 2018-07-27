package com.hsae.belus

import android.util.Log
import java.io.DataOutputStream

class Logic {
    fun click(x:Int,y:Int){
        try {
            var p = Runtime.getRuntime().exec("su\n")
            val dos = DataOutputStream(p.outputStream)
            dos.writeBytes("input tap $x $y\n")
            dos.writeBytes("exit\n")
            dos.flush()
            dos.close()
            p.waitFor()
        } catch (ex: Exception) {
            Log.i("Command", ex.message)
        }
    }
    fun hold(x:Int,y:Int,time:Int){
        try {
            var p = Runtime.getRuntime().exec("su\n")
            val dos = DataOutputStream(p.outputStream)
            dos.writeBytes("input swipe $x $y $x $y $time\n")
            dos.writeBytes("exit\n")
            dos.flush()
            dos.close()
            p.waitFor()
        } catch (ex: Exception) {
            Log.i("Command", ex.message)
        }
    }
    fun swipe(x1:Int,y1:Int,x2:Int,y2:Int,time:Int){
        try {
            var p = Runtime.getRuntime().exec("su\n")
            val dos = DataOutputStream(p.outputStream)
            dos.writeBytes("input swipe $x1 $y1 $x2 $y2 $time\n")
            dos.writeBytes("exit\n")
            dos.flush()
            dos.close()
            p.waitFor()
        } catch (ex: Exception) {
            Log.i("Command", ex.message)
        }
    }
    fun cutScreen(){
        try {
            var p = Runtime.getRuntime().exec("su\n")
            val dos = DataOutputStream(p.outputStream)
            dos.writeBytes("screencap -p /data/local/tmp/tmp.png\n")
            dos.writeBytes("exit\n")
            dos.flush()
            dos.close()
            p.waitFor()
        } catch (ex: Exception) {
            Log.i("Command", ex.message)
        }
    }
}