package com.beaven.wanandroid.mvp.main.view

import android.content.Intent
import com.beaven.wanandroid.R.layout
import com.beaven.wanandroid.base.BaseActivity
import com.beaven.wanandroid.mvp.main.MainView
import com.beaven.wanandroid.mvp.main.bean.HomeListData
import com.beaven.wanandroid.mvp.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.button_request
import kotlinx.android.synthetic.main.activity_main.text_content

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    override fun getLayoutId(): Int {
        return layout.activity_main
    }

    override fun initData(intent: Intent) {

    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun initView() {
        button_request.setOnClickListener {
            presenter.request()
        }
    }

    override fun showResult(result: HomeListData) {
        text_content.text = result.toString()
    }
}
