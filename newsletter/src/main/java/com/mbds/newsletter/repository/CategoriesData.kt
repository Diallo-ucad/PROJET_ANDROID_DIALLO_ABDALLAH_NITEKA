package com.mbds.newsletter.repository

import com.mbds.newsletter.model.Category

object CategoriesData {
    val dataList = listOf(
        Category(
            name = "business",
            label = "entreprise",
            image = "https://i.picsum.photos/id/1075/500/300.jpg?hmac=5DhRFK2dTT-URjGdj3Fgb8fBZOGnqy-lIR1gIm_JJ3U"
        ),
        Category(
            name = "entertainment",
            label = "divertissement",
            image = "https://picsum.photos/500/300?random=1"
        ),
        Category(
            name = "general",
            label = "général",
            image = "https://picsum.photos/500/300?random=2"
        ),
        Category(
            name = "health",
            label = "santé",
            image = "https://picsum.photos/500/300?random=3"
        ),
        Category(
            name = "science",
            label = "sciences",
            image = "https://picsum.photos/500/300?random=4"
        ),
        Category(
            name = "sports",
            image = "https://picsum.photos/500/300?random=5"
        )//,
       // Category(
        //    name = "technology",
        //    image = "https://picsum.photos/500/300?random=6"
       // )
    )
}