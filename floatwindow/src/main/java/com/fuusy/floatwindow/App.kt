package com.fuusy.floatwindow

import android.app.Application
import android.content.Context

/**
 * Created by roc on 2022/7/19.
 */
class App : Application() {

    var context: Context? = null
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }


}