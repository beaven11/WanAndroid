package com.beaven.wanandroid.mvp.main.view

import android.content.Intent
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.beaven.wanandroid.R
import com.beaven.wanandroid.base.BaseActivity
import com.beaven.wanandroid.mvp.main.MainView
import com.beaven.wanandroid.mvp.main.bean.HomeListData
import com.beaven.wanandroid.mvp.main.presenter.MainPresenter
import com.beaven.wanandroid.mvp.main.presenter.RecyclerHomeAdapter
import kotlinx.android.synthetic.main.activity_main.recycler_home

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    private lateinit var adapter: RecyclerHomeAdapter

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData(intent: Intent) {

    }

    override fun initPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun initView() {
        recycler_home.layoutManager = LinearLayoutManager(this)
        recycler_home.setHasFixedSize(true)
        recycler_home.addItemDecoration(
                DividerItemDecoration(recycler_home.context, DividerItemDecoration.VERTICAL)
        )
        adapter = RecyclerHomeAdapter()
        recycler_home.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.request()
    }

    override fun showResult(result: HomeListData) {
        adapter.setData(result.datas)
    }
}
