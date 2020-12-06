package com.ebs.home.model

data class HomeMainContent(
    var contentType:String,
    var contentName: String,
    var viewType: Int,
    var contentList: ArrayList<Contents>
)