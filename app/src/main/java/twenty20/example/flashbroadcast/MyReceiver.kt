package twenty20.example.flashbroadcast

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import java.lang.Exception
import java.lang.reflect.Parameter
import java.security.Policy
import java.util.jar.Manifest

@Suppress("DEPRECATION")
public class MyReceiver(): BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        var cameram = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        var cameraid = cameram.cameraIdList[0]
        var myString: String = "0101010101010101010101010101010101010101010101010101010101010101"
        var blinkdelay: Long = 50
        var state: String = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            Toast.makeText(context, "Ringing", Toast.LENGTH_SHORT).show()
            for (i in 0 until myString.length) {
                if (myString[i] == '0') {
                    cameram.setTorchMode(cameraid, true)
                } else {
                    cameram.setTorchMode(cameraid, false)
                }
                if (state != TelephonyManager.EXTRA_STATE_IDLE && state != TelephonyManager.EXTRA_STATE_OFFHOOK) {
                    try {
                        Thread.sleep(blinkdelay)
                        continue

                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                } else {
                    cameram.setTorchMode(cameraid, false)
                    break
                }
            }
        }
           else if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                cameram.setTorchMode(cameraid, false)
                  }
            else if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                cameram.setTorchMode(cameraid, false)
                }


    }
}



