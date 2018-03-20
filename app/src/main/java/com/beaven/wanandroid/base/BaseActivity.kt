package com.beaven.wanandroid.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

/**
 * 创建时间: 2018/03/12 17:31<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/12 17:31<br>
 * 描述:
 */

abstract class BaseActivity<T : BaseContract.BasePresenter> : AppCompatActivity(),
        BaseContract.BaseView {

    protected lateinit var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData(intent)
        initView()
        presenter = initPresenter()
        presenter.onCreate()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    abstract fun getLayoutId(): Int

    abstract fun initPresenter(): T

    abstract fun initData(intent: Intent)

    abstract fun initView()

    override fun showToastDialog(message: String) {
        val dialog = alert(message) {
            yesButton { }
        }
        dialog.show()
    }

    override fun showErrorView(error: String) {
    }

    override fun getView(): FragmentActivity {
        return this
    }
}