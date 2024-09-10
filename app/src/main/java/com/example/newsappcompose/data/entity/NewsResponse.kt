package com.example.newsappcompose.data.entity

data class NewsResponse(
    val status: String?,
    val totalResults: Int,
    val articles: List<Articles>
)

data class Articles (
    val title: String?,
    val author : String?,
    val description: String,
    val content: String?,
    val url: String?,
    val urlToImage: String?,
    val publishAt: String? = "",
    val source: Source
)
data class Source(
    val id: String? ,
    val name: String?
)
