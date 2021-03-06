package com.beaven.wanandroid.base

import android.support.v4.app.FragmentActivity
import com.beaven.wanandroid.base.BaseContract.BaseView
import com.beaven.wanandroid.data.net.HttpManager
import com.beaven.wanandroid.data.net.HttpResult
import com.beaven.wanandroid.util.Logger
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.JobCancellationException
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

/**
 * 创建时间: 2018/03/20 10:17<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/20 10:17<br>
 * 描述:
 */
open class BasePresenter(private val view: BaseView) : BaseContract.BasePresenter {

    private val deferredList = ArrayList<Deferred<Any>>()

    protected val apiService = HttpManager.getService()

    override fun onCreate() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onDestroy() {
        deferredList.forEach {
            try {
                if (it.isActive) {
                    it.cancel()
                }
            } catch (cancel: JobCancellationException) {

            }
        }
    }

    override fun getActivity(): FragmentActivity {
        return view.getView()
    }

    protected fun <T> Deferred<HttpResult<T>>.callRequest(
        errorAction: ((Exception) -> Unit)? = null,
        action: (T) -> Unit
    ) {
        async(UI) {
            try {
                val req = this@callRequest
                deferredList.add(req)
                val result = req.await()
                action(result.convert())
            } catch (e: Exception) {
                if (errorAction != null) {
                    errorAction(e)
                } else {
                    e.message?.let { view.showErrorView(it) }
                }
                Logger.error(e)
            }
        }
    }

    private fun <T> HttpResult<T>.convert(): T {
        val errorCode = this.errorCode
        val errorMessage = this.errorMsg
        if (errorCode < 0) {
            throw IllegalArgumentException(errorMessage)
        } else {
            return this.data
        }
    }
}