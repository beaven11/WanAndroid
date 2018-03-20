package com.beaven.wanandroid.mvp.main.presenter

import com.beaven.wanandroid.base.BasePresenter
import com.beaven.wanandroid.mvp.main.MainPresenter
import com.beaven.wanandroid.mvp.main.MainView

/**
 * 创建时间: 2018/03/20 10:45<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/20 10:45<br>
 * 描述:
 */
class MainPresenter(private val view: MainView) : BasePresenter(view),
        MainPresenter {

    override fun request() {
        callRequest(apiService.getHomeList(0)) {
            view.showResult(it)
        }
    }

}