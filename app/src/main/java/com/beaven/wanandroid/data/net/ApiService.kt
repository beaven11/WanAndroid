package com.beaven.wanandroid.data.net

import com.beaven.wanandroid.mvp.main.bean.HomeListData
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 创建时间: 2018/03/16 15:10<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/16 15:10<br>
 * 描述:
 */
interface ApiService {

    @GET("/article/list/{index}/json")
    fun getHomeList(@Path("index") index: Int): Deferred<HttpResult<HomeListData>>
}