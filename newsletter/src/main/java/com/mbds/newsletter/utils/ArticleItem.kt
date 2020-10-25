package com.mbds.newsletter.utils

import java.util.*

data class ArticleItem(
        val title: String,
        val url: String,
        val description: String,
        val urlToImage: String,
        val author: String,
        val publishedAt: Date,
        val content: String
)