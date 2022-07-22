package com.fuusy.screenadapter

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration


/**
 * 今日头条方案
 * Created by roc on 2022/7/7.
 */
object DensityUtil {
    private const val WIDTH = 320f //参考设备的宽，单位是dp 320 / 2 = 160
    private var appDensity //表示屏幕密度
            = 0f
    private var appScaleDensity //字体缩放比例，默认appDensity
            = 0f

    fun setDensity(application: Application, activity: Activity) {
        //0.获取当前app的屏幕显示信息
        val displayMetrics = application.resources.displayMetrics
        if (appDensity == 0f) {
            //1.初始化赋值操作 获取app初始density和scaledDensity
            appDensity = displayMetrics.density
            appScaleDensity = displayMetrics.scaledDensity

            application.registerComponentCallbacks(object :ComponentCallbacks{
                override fun onConfigurationChanged(newConfig: Configuration) {
                    //在手机系统内调节字体大小，为了保证字体同步，重新对scaleDensity进行赋值
                    if (newConfig.fontScale > 0) {
                        appScaleDensity = application.resources.displayMetrics.scaledDensity
                    }
                }

                override fun onLowMemory() {
                }

            })

        }

        /*
         2.计算目标值density, scaleDensity, densityDpi
         targetDensity为当前设备的宽度/设计稿固定的宽度
         targetScaleDensity：目标字体缩放Density，等比例测算
         targetDensityDpi：density = dpi / 160 即dpi=density*160
         */
        val targetDensity = displayMetrics.widthPixels / WIDTH
        val targetScaleDensity = targetDensity * (appScaleDensity / appDensity)
        val targetDensityDpi = (targetDensity * 160).toInt()

        //3.替换Activity的density, scaleDensity, densityDpi
        val dm = activity.resources.displayMetrics
        dm.density = targetDensity
        dm.scaledDensity = targetScaleDensity
        dm.densityDpi = targetDensityDpi
    }
}
