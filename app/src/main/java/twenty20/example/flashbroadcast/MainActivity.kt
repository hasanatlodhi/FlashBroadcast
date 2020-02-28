package twenty20.example.flashbroadcast

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.reflect.Parameter

public class MainActivity : AppCompatActivity() {
    private val PERMISSION_CODE = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED &&checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED)
            {
                val permission = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE)
                requestPermissions(permission, PERMISSION_CODE)
            }
            else{
                text.setText("You Have Granted Permissions")

            }
        }
        else
        {
            text.setText("You Have Granted Permissions")
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup was granted
                    var toast=Toast.makeText(this,"Pemissions Granted For Flash!",Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER,0,0)
                    toast.show()
                    text.setText("You Have Granted Permissions!")
                }
                else{
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                    text.setText("Please Enable the Permissions From Settings")
                }
            }
        }
         }
}