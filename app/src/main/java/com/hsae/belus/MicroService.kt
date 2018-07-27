package com.hsae.belus
import android.util.Log
import com.koushikdutta.async.AsyncServer
import com.koushikdutta.async.AsyncServerSocket
import com.koushikdutta.async.AsyncSocket
import com.koushikdutta.async.ByteBufferList
import com.koushikdutta.async.callback.ListenCallback
import java.lang.Exception


class MicroService {
    private var port:Int=0
    class MsCallback:ListenCallback{
        private var sock:AsyncSocket?=null
        private fun handleMsg(bb: ByteBufferList){
            Log.i("Belus",bb.readString())
            sock?.write(ByteBufferList("hello".toByteArray()))
        }
        override fun onAccepted(socket: AsyncSocket?) {
            Log.i("belus","onAccepted")
            sock=socket
            socket?.setDataCallback { _, bb -> handleMsg(bb) }
            socket?.setClosedCallback {  }
            socket?.setEndCallback {  }
        }

        override fun onCompleted(ex: Exception?) {
            Log.i("belus","onCompleted")
        }

        override fun onListening(socket: AsyncServerSocket?) {
            Log.i("belus","onListening")
        }
    }

    fun createServer(port_:Int){
        Thread({
            port = port_
            AsyncServer.getDefault().listen(null,port,MsCallback())
        }).start()
    }
}