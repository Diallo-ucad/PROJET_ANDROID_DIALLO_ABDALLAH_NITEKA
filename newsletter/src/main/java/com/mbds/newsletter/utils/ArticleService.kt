package com.mbds.newsletter.utils

import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    @GET("/articles")
    fun list(): Call<List<ArticleItem>>
}

