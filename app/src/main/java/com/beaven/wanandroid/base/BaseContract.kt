package com.beaven.wanandroid.base

import android.support.v4.app.FragmentActivity

/**
 * 创建时间: 2018/03/12 17:26<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/12 17:26<br>
 * 描述:
 */
interface BaseContract {

    interface BaseView {

        fun showToastDialog(message: String)

        fun showErrorView(error: String)

        fun getView(): FragmentActivity
    }

    interface BasePresenter {

        fun onCreate()

        fun onResume()

        fun onPause()

        fun onDestroy()

        fun getActivity(): FragmentActivity
    }
}