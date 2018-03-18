package com.beaven.wanandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
    }

    fun test() {
        doAsync {
            println(Thread.currentThread().name)
            val result = 3 + 2
            Thread.sleep(3000)
            uiThread {
                println(Thread.currentThread().name)
                println(result)
            }
        }
    }
}
