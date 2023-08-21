package com.example.mad_practical_5_21012011169

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browserBtn : Button = findViewById(R.id.button1)
        val browserEditText : EditText = findViewById(R.id.editText1)

        browserBtn.setOnClickListener{
            openUrl(browserEditText.text.toString())
        }


        val CallBtn : Button = findViewById(R.id.button2)
        val CallEditText : EditText = findViewById(R.id.editText2)

        CallBtn.setOnClickListener{
            callNo(CallEditText.text.toString())
        }
        val CallLogBtn : Button = findViewById(R.id.button3)

        CallLogBtn.setOnClickListener{
            callLog()
        }
        val GalleryBtn : Button = findViewById(R.id.button4)

        GalleryBtn.setOnClickListener{
            openGallery()
        }
        val CameraBtn : Button = findViewById(R.id.button5)

        CameraBtn.setOnClickListener{
            openCamera()
        }
        val AlarmBtn : Button = findViewById(R.id.button6)

        AlarmBtn.setOnClickListener{
            openAlarm()
        }
    }

    fun openUrl(url:String){
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun callNo(no:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$no")).also { startActivity(it) }
    }
    fun callLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    fun openGallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    fun openAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }
}
