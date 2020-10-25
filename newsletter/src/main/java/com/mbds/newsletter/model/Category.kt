package com.mbds.newsletter.model

data class Category(
    val name: String,
    var label: String = name,
    val image: String
)