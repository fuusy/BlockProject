package com.fuusy.screenadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by roc on 2022/7/7.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DensityUtil.setDensity(application,this)
    }
}