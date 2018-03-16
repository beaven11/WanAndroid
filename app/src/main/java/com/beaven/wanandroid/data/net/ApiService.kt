package com.beaven.wanandroid.data.net

import retrofit2.Call

/**
 * 创建时间: 2018/03/16 15:10<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/16 15:10<br>
 * 描述:
 */
interface ApiService {

    fun requestTest(): Call<String>
}