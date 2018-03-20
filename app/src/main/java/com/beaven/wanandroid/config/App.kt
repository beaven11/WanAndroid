package com.beaven.wanandroid.config

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * 创建时间: 2018/03/12 17:11<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/12 17:11<br>
 * 描述:
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}