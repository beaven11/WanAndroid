package com.beaven.wanandroid.data.net

import com.beaven.wanandroid.BuildConfig
import com.beaven.wanandroid.util.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import java.util.concurrent.TimeUnit

/**
 * 创建时间: 2018/03/12 17:38<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/12 17:38<br>
 * 描述:
 */
object HttpManager {

    fun httpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor(
                HttpLoggingInterceptor.Logger { message: String? ->
                    val text = message ?: "http request body is null"
                    Logger.d(text, "HttpRequest")
                })
        interceptor.level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
        return OkHttpClient.Builder().connectTimeout(
                60, TimeUnit.SECONDS
        ).readTimeout(60, TimeUnit.SECONDS).addNetworkInterceptor(interceptor).writeTimeout(
                60, TimeUnit.SECONDS
        ).build()
    }

}