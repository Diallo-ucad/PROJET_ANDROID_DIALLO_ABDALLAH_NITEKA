package com.mbds.newsletter.services

import com.mbds.newsletter.model.ArticleObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("top-headlines")
    suspend fun list(
        @Query("category") category: String = "health",
        @Query("apiKey") apiKey: String,
        @Query("country") country: String = "fr"
    ): Response<ArticleObject>
}

