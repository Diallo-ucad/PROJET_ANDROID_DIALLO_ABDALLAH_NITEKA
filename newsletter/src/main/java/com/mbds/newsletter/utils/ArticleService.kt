package com.mbds.newsletter.utils

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleService {
    @GET("top-headlines?apiKey=e547106de0e74054bf6ab4f63a9a2e59&country=fr")
    suspend fun list(@Query("category") category: String = "health"): Response<ArticleObject>
}

