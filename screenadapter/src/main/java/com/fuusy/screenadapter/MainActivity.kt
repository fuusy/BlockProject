package com.fuusy.screenadapter

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import androidx.annotation.RequiresApi

class MainActivity : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFullScreen()
        hideSystemUI()
        setDisplayCutoutMode(LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER)
        setContentView(R.layout.activity_main)
    }


    /**
     * 判断当前设备是否有刘海
     */
    @RequiresApi(Build.VERSION_CODES.P)
    private fun hasCutout(): Boolean {
        window.decorView.rootWindowInsets?.let {
            it.displayCutout?.let {
                if (it.boundingRects.size > 0 && it.safeInsetTop > 0) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * @param mode 刘海屏下内容显示模式，针对Android9.0
    LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT = 0; //在竖屏模式下，内容会呈现到刘海区域中；但在横屏模式下，内容会显示黑边
    LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER = 2;//不允许内容延伸进刘海区
    LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES = 1;//在竖屏模式和横屏模式下，内容都会呈现到刘海区域中
     */
    @RequiresApi(Build.VERSION_CODES.P)
    private fun setDisplayCutoutMode(mode: Int) {
        window.attributes.apply {
            this.layoutInDisplayCutoutMode = mode
            window.attributes = this
        }

    }

    /**
     * 设置全屏
     */
    private fun setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

}