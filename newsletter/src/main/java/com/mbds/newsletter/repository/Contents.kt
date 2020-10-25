package com.mbds.newsletter.repository

import com.mbds.newsletter.model.Category
import com.mbds.newsletter.model.ArticleItem
import com.mbds.newsletter.services.ArticleService
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
object Contents {
    private val service: ArticleService
    private const val baseUrl: String = "http://newsapi.org/v2/"
    private const val apiKey: String = "e547106de0e74054bf6ab4f63a9a2e59"
    private const val country: String = "fr"

    suspend fun articleList(category: Category): List<ArticleItem> {
        val response = service.list(category = category.name, apiKey = apiKey, country = country)
        val articles: List<ArticleItem>? = response.body()?.articles
            ?.filter {
                !it.urlToImage.isNullOrBlank()
            }
        return  articles ?:emptyList()
    }
    fun categoryList(): List<Category> = CategoriesData.dataList.map {
        it.label = it.label.capitalize()
        return@map it
    }
    init {
        // Loggin
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(ArticleService::class.java)
    }


}