package com.beaven.wanandroid.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.beaven.wanandroid.util.Logger

/**
 * 创建时间: 2018/03/12 17:31<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/12 17:31<br>
 * 描述:
 */

abstract class BaseActivity : AppCompatActivity(), BaseContract.BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showDialog(message: String) {
        Logger.d("show dialog $message")
    }
}