package com.mbds.newsletter.utils

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ArticleService {
    @GET("top-headlines?apiKey=e547106de0e74054bf6ab4f63a9a2e59&country=fr&category=health")
    suspend fun list(): Response<ArticleObject>
}

