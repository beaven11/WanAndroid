package com.beaven.wanandroid.util

import android.util.Log

/**
 * 创建时间: 2018/03/12 17:13<br></br>
 * 创建人: 王培峰<br></br>
 * 修改人: 王培峰<br></br>
 * 修改时间: 2018/03/12 17:13<br></br>
 * 描述:
 */
object Logger {

    private const val TAG = "WanAndroid"

    fun d(
        message: String,
        tag: String = TAG
    ) {
        Log.d(tag, message)
    }

    fun i(
        message: String,
        tag: String = TAG
    ) {
        Log.i(tag, message)
    }

    fun e(
        message: String,
        tag: String = TAG
    ) {
        Log.e(tag, message)
    }
}
