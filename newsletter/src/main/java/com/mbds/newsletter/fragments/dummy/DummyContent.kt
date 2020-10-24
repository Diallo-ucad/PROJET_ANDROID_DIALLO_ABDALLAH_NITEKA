package com.mbds.newsletter.fragments.dummy

import com.mbds.newsletter.utils.ArticleItem
import com.mbds.newsletter.utils.ArticleService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {
    private val service: ArticleService
    init {
        println(" ********************************************************* INIT ")
        val logging = HttpLoggingInterceptor()
// set your desired log level
// set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
// add your other interceptors …

// add logging as last interceptor
// add your other interceptors …

// add logging as last interceptor
        httpClient.addInterceptor(logging) // <-- this is the important line!


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        println(" ********************************************************* INIT 2 ${retrofit.toString()}")
        service = retrofit.create(ArticleService::class.java)
        println(" ********************************************************* INIT FIN ")
    }
    fun list(): List<ArticleItem> {
        println(" ********************************************************* Commencement ")
        val response = service.list().execute()
        println(" ********************************************************* ")
        println("response : ${response.code()} ${response.message()}")
        println("body : ${response.body()?.status}")
        return  emptyList()
    }
    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}