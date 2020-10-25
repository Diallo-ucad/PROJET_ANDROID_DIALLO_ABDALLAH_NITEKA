package com.mbds.newsletter.utils

data class ArticleItem(
        val title: String,
        val url: String,
        val description: String = "Nada" ,
        val urlToImage: String,
        val author: String,
        val publishedAt: String,
        val content: String
)