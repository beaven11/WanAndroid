package com.beaven.wanandroid.mvp.main.bean

/**
 * 创建时间: 2018/03/20 14:47<br>
 * 创建人: 王培峰<br>
 * 修改人: 王培峰<br>
 * 修改时间: 2018/03/20 14:47<br>
 * 描述:
 */

data class HomeListData(
    val curPage: Int,
    val datas: List<HomeListDataItem>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class HomeListDataItem(
    val apkLink: String,
    val author: String,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String?,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    val niceDate: String,
    val origin: String,
    val projectLink: String,
    val publishTime: Long,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<HomeDataItemTag>,
    val title: String,
    val type: Int,
    val visible: Int,
    val zan: Int
)

data class HomeDataItemTag(
    val name: String,
    val url: String
)