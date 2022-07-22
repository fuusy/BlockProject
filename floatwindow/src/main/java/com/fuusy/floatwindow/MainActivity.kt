package com.fuusy.floatwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_play).setOnClickListener {
            Intent(this,VideoPlayActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}