package com.fuusy.blockproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private val mList = arrayListOf<IntRange>(0..20)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent(this, MyService::class.java).apply {
            startService(this)

        }

        Intent().apply {
            sendBroadcast(this)
        }

        mList.forEach {

        }
    }
}