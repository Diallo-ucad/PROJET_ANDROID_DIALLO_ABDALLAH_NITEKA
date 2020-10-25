package com.mbds.newsletter.utils

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleService {
    @GET("top-headlines")
    suspend fun list(
        @Query("category") category: String = "health",
        @Query("apiKey") apiKey: String,
        @Query("country") country: String = "fr"
    ): Response<ArticleObject>
}

