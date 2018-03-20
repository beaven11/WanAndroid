package com.beaven.wanandroid.data.net

import com.google.gson.annotations.SerializedName

/**
 * 创建时间: 2018/03/20 14:44<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/20 14:44<br>
 * 描述:
 */
data class HttpResult<out T>(
    @SerializedName("errorcode")
    val errorCode: Int,
    @SerializedName("errormsg")
    val errorMsg: String,
    val data: T
)