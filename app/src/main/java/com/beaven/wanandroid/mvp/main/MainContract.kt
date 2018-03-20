package com.beaven.wanandroid.mvp.main

import com.beaven.wanandroid.base.BaseContract
import com.beaven.wanandroid.mvp.main.bean.HomeListData

/**
 * 创建时间: 2018/03/20 14:10<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/20 14:10<br>
 * 描述:
 */

interface MainView : BaseContract.BaseView {
    fun showResult(result: HomeListData)
}

interface MainPresenter : BaseContract.BasePresenter {

    fun request()
}