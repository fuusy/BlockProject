package com.fuusy.floatwindow

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.VideoView

class VideoPlayActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_play2)
    }

    override fun onResume() {
        super.onResume()
        initVideo()
    }


    private fun initVideo() {
        val videoViewContain = findViewById<CustonVideoLayout>(R.id.rl_video_contain)

        findViewById<Button>(R.id.bt_small_window).setOnClickListener {
            //
            FloatWindowManager.getInstance(this)?.showFloatWindow(videoViewContain)
            finish()
        }
    }
}