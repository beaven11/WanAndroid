package com.beaven.wanandroid.mvp.detail.view

import android.content.Intent
import com.beaven.wanandroid.R
import com.beaven.wanandroid.base.BaseActivity
import com.beaven.wanandroid.mvp.detail.DetailView
import com.beaven.wanandroid.mvp.detail.presenter.DetailPresenter

class DetailActivity : BaseActivity<DetailPresenter>(), DetailView {

    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun initData(intent: Intent) {
    }

    override fun initView() {
    }

    override fun initPresenter(): DetailPresenter {
        return DetailPresenter(this)
    }
}
