package com.beaven.wanandroid.data.net

import com.beaven.wanandroid.BuildConfig
import com.beaven.wanandroid.util.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * 创建时间: 2018/03/12 17:38<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/12 17:38<br>
 * 描述:
 */
object HttpManager {

    private const val TIME_OUT = 60
    private const val BASE_URL = "http://www.mejust.com"

    private fun client(): OkHttpClient {
        return with(OkHttpClient.Builder()) {
            connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        }.also {
            it.addInterceptor(
                    HttpLoggingInterceptor(
                            HttpLoggingInterceptor.Logger { message: String? ->
                                val text = message ?: "http request body is null"
                                Logger.d(text, "HttpRequest")
                            }).apply {
                        level = if (BuildConfig.DEBUG) BODY else NONE
                    }
            )
        }.build()
    }

    fun getService(): ApiService {
        return with(Retrofit.Builder()) {
            baseUrl(BASE_URL)
            client(client())
        }.build().create(ApiService::class.java)
    }
}