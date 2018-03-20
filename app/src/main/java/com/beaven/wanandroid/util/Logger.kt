package com.beaven.wanandroid.util

import com.beaven.wanandroid.config.TAG_ALL
import timber.log.Timber

/**
 * 创建时间: 2018/03/20 15:31<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/20 15:31<br>
 * 描述:
 */
object Logger {

    fun debug(
        message: String,
        tag: String = TAG_ALL
    ) {
        Timber.tag(tag).d(message)
    }

    fun info(
        message: String,
        tag: String = TAG_ALL
    ) {
        Timber.tag(tag).i(message)
    }

    fun error(
        t: Throwable,
        message: String = "",
        tag: String = TAG_ALL
    ) {
        Timber.tag(tag).e(t, message)
    }
}