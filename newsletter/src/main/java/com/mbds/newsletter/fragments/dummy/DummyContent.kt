package com.mbds.newsletter.fragments.dummy

import com.mbds.newsletter.utils.ArticleItem
import com.mbds.newsletter.utils.ArticleService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {
    private val service: ArticleService
    init {
        // Loggin
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(ArticleService::class.java)
    }
    suspend fun list(category: String): List<ArticleItem> {
        val response = service.list(category)
        println("body : ${response.body()?.articles?.map { it.title }}")
        return  response.body()?.articles ?:emptyList()
    }
}