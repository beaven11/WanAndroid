package com.beaven.wanandroid.mvp.detail.view

import android.content.Intent
import android.view.MenuItem
import android.webkit.WebView
import android.widget.FrameLayout.LayoutParams
import com.beaven.wanandroid.R
import com.beaven.wanandroid.base.BaseActivity
import com.beaven.wanandroid.mvp.detail.DetailView
import com.beaven.wanandroid.mvp.detail.presenter.DetailPresenter
import kotlinx.android.synthetic.main.activity_detail.layout_detail

class DetailActivity : BaseActivity<DetailPresenter>(), DetailView {

    companion object {
        const val URL_PARAM = "url_param"
    }

    private var url: String? = null

    private var webView: WebView? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun initData(intent: Intent) {
        url = intent.getStringExtra(URL_PARAM)
    }

    override fun initView() {
        supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
        }
        webView = WebView(this)
        layout_detail.addView(
                webView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        )
        url?.let {
            webView?.loadUrl(it)
        }
    }

    override fun initPresenter(): DetailPresenter {
        return DetailPresenter(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        webView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        webView?.onPause()
    }

    override fun onDestroy() {
        webView?.let {
            it.loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
            it.clearHistory()
            layout_detail.removeView(it)
            it.destroy()
        }
        webView = null
        super.onDestroy()
    }
}
