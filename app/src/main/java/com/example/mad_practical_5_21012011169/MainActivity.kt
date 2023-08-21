package com.example.mad_practical_5_21012011169

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openUrl(url:String){
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also { startActivity(it) }
    }
    fun callNo(no:String){
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$no")).also { startActivity(it) }
    }
    fun callLog(){
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also {  }
    }
    fun openGallery(){
        Intent(Intent.ACTION_VIEW).setType("image/*").also {  }
    }
    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {  }
    }
    fun openAlarm(){
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also {  }
    }
}
