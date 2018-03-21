package com.beaven.wanandroid.mvp.main.presenter

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.beaven.wanandroid.R
import com.beaven.wanandroid.R.id
import com.beaven.wanandroid.mvp.detail.view.DetailActivity
import com.beaven.wanandroid.mvp.main.bean.HomeListDataItem
import org.jetbrains.anko.startActivity
import java.util.Locale

/**
 * 创建时间: 2018/03/21 15:10<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/21 15:10<br>
 * 描述:
 */
class RecyclerHomeAdapter(private val dataList: ArrayList<HomeListDataItem> = ArrayList()) :
        Adapter<ViewHolderHome>() {

    override fun onCreateViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): ViewHolderHome {
        val view = LayoutInflater.from(parent?.context).inflate(
                R.layout.item_list_home, parent, false
        )
        return ViewHolderHome(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(
        holder: ViewHolderHome?,
        position: Int
    ) {
        val item = dataList[position]
        holder?.textTitle?.text = item.title
        holder?.textDesc?.text = holder?.itemView?.context?.getString(
                R.string.text_desc_format
        )?.let {
            String.format(
                    Locale.getDefault(), it, item.author, item.chapterName, item.niceDate
            )
        }
        holder?.itemView?.setOnClickListener {
            it.context.startActivity<DetailActivity>(DetailActivity.URL_PARAM to item.link)
        }
    }

    fun setData(dates: List<HomeListDataItem>) {
        dataList.clear()
        dataList.addAll(dates)
        notifyDataSetChanged()
    }
}

class ViewHolderHome(view: View) : ViewHolder(view) {

    val textTitle: TextView = view.findViewById(id.text_title_home)

    val textDesc: TextView = view.findViewById(id.text_desc_home)
}