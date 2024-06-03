package com.sharkdroid.medhavicollege.presentation.news.components

import java.util.Date

data class NewsItem(
    val image: Int,
    val headline:String,
    val description:String,
    val date: Date = Date()
)
